import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.*;

public class AnimalProjectTest {

    // -------------------------------------------------------------------------
    // TrainingLevel enum
    // -------------------------------------------------------------------------

    @Test
    @DisplayName("TrainingLevel deve ter as 4 constantes definidas")
    void trainingLevel_constants() throws Exception {
        Class<?> cls = Class.forName("enums.TrainingLevel");
        Object[] constants = cls.getEnumConstants();
        assertNotNull(constants, "TrainingLevel não foi encontrado ou está vazio");
        assertEquals(4, constants.length,
                "TrainingLevel precisa ter exatamente 4 constantes: BEGINNER, INTERMEDIATE, ADVANCED, PROFESSIONAL");
    }

    @Test
    @DisplayName("TrainingLevel.getDisplayName() deve retornar o nome correto para cada constante")
    void trainingLevel_displayName() throws Exception {
        Class<?> cls = Class.forName("enums.TrainingLevel");
        Method getDisplayName = cls.getMethod("getDisplayName");

        Object[] constants = cls.getEnumConstants();
        assertNotNull(constants, "TrainingLevel não possui constantes");

        String[] expectedNames = { "Beginner", "Intermediate", "Advanced", "Professional" };
        for (int i = 0; i < Math.min(constants.length, expectedNames.length); i++) {
            String actual = (String) getDisplayName.invoke(constants[i]);
            assertEquals(expectedNames[i], actual,
                    "getDisplayName() incorreto para a constante " + constants[i]);
        }
    }

    @Test
    @DisplayName("TrainingLevel.fromCode() deve retornar a constante correta")
    void trainingLevel_fromCode() throws Exception {
        Class<?> cls = Class.forName("enums.TrainingLevel");
        Method fromCode = cls.getMethod("fromCode", int.class);
        Object[] constants = cls.getEnumConstants();
        assertNotNull(constants, "TrainingLevel não possui constantes");

        for (Object constant : constants) {
            Method getCode = cls.getMethod("getCode");
            int code = (int) getCode.invoke(constant);
            Object result = fromCode.invoke(null, code);
            assertEquals(constant, result,
                    "fromCode(" + code + ") não retornou a constante esperada");
        }
    }

    @Test
    @DisplayName("TrainingLevel.fromCode() deve lançar exceção para código inválido")
    void trainingLevel_fromCode_invalid() throws Exception {
        Class<?> cls = Class.forName("enums.TrainingLevel");
        Method fromCode = cls.getMethod("fromCode", int.class);
        InvocationTargetException ex = assertThrows(InvocationTargetException.class,
                () -> fromCode.invoke(null, 99));
        assertTrue(ex.getCause() instanceof IllegalArgumentException,
                "fromCode(99) deveria lançar IllegalArgumentException");
    }

    // -------------------------------------------------------------------------
    // FurColor enum
    // -------------------------------------------------------------------------

    @Test
    @DisplayName("FurColor deve ter as 7 constantes definidas")
    void furColor_constants() throws Exception {
        Class<?> cls = Class.forName("enums.FurColor");
        Object[] constants = cls.getEnumConstants();
        assertNotNull(constants, "FurColor não foi encontrado ou está vazio");
        assertEquals(7, constants.length,
                "FurColor precisa ter 7 constantes: BLACK, WHITE, ORANGE_TABBY, GRAY, BROWN, CALICO, SPOTTED");
    }

    @Test
    @DisplayName("FurColor.getDisplayName() deve retornar o nome correto para cada constante")
    void furColor_displayName() throws Exception {
        Class<?> cls = Class.forName("enums.FurColor");
        Method getDisplayName = cls.getMethod("getDisplayName");

        Object[] constants = cls.getEnumConstants();
        assertNotNull(constants, "FurColor não possui constantes");
        assertEquals(7, constants.length, "FurColor precisa ter 7 constantes para este teste");

        String[] expectedNames = { "Black", "White", "Orange Tabby", "Gray", "Brown", "Calico", "Spotted" };
        for (int i = 0; i < expectedNames.length; i++) {
            String actual = (String) getDisplayName.invoke(constants[i]);
            assertEquals(expectedNames[i], actual,
                    "getDisplayName() incorreto para a constante " + constants[i]);
        }
    }

    @Test
    @DisplayName("FurColor.fromCode() deve retornar a constante correta")
    void furColor_fromCode() throws Exception {
        Class<?> cls = Class.forName("enums.FurColor");
        Method fromCode = cls.getMethod("fromCode", int.class);
        Object[] constants = cls.getEnumConstants();
        assertNotNull(constants, "FurColor não possui constantes");
        assertTrue(constants.length > 0, "FurColor precisa ter constantes implementadas");

        for (Object constant : constants) {
            Method getCode = cls.getMethod("getCode");
            int code = (int) getCode.invoke(constant);
            Object result = fromCode.invoke(null, code);
            assertEquals(constant, result,
                    "fromCode(" + code + ") não retornou a constante esperada");
        }
    }

    @Test
    @DisplayName("FurColor.fromCode() deve lançar exceção para código inválido")
    void furColor_fromCode_invalid() throws Exception {
        Class<?> cls = Class.forName("enums.FurColor");
        Method fromCode = cls.getMethod("fromCode", int.class);
        InvocationTargetException ex = assertThrows(InvocationTargetException.class,
                () -> fromCode.invoke(null, 99));
        assertTrue(ex.getCause() instanceof IllegalArgumentException,
                "fromCode(99) deveria lançar IllegalArgumentException");
    }

    // -------------------------------------------------------------------------
    // Dog — herança e métodos (classe fornecida, não deve ser alterada)
    // -------------------------------------------------------------------------

    @Test
    @DisplayName("Dog deve estender Animal")
    void dog_extendsAnimal() throws Exception {
        Class<?> dog = Class.forName("model.Dog");
        Class<?> animal = Class.forName("model.Animal");
        assertTrue(animal.isAssignableFrom(dog), "Dog precisa usar 'extends Animal'");
    }

    @Test
    @DisplayName("Dog deve ter construtor com os atributos corretos")
    void dog_constructor() throws Exception {
        Class<?> dogClass = Class.forName("model.Dog");
        Class<?> trainingClass = Class.forName("enums.TrainingLevel");

        Constructor<?> constructor = assertDoesNotThrow(() -> dogClass.getConstructor(
                String.class, int.class, double.class,
                String.class, boolean.class, trainingClass, String.class, int.class),
                "Dog precisa ter construtor com: name, age, weight, breed, isVaccinated, trainingLevel, ownerName, barkVolume");
        assertNotNull(constructor);
    }

    @Test
    @DisplayName("Dog.makeSound() deve conter 'barks' na saída")
    void dog_makeSound() throws Exception {
        Class<?> dogClass = Class.forName("model.Dog");
        Class<?> trainingClass = Class.forName("enums.TrainingLevel");

        Object training = trainingClass.getEnumConstants()[0];

        Constructor<?> ctor = dogClass.getConstructor(
                String.class, int.class, double.class,
                String.class, boolean.class, trainingClass, String.class, int.class);
        Object dog = ctor.newInstance("Rex", 3, 15.0, "Labrador", true, training, "João", 75);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        dogClass.getMethod("makeSound").invoke(dog);
        System.setOut(System.out);

        assertTrue(out.toString().contains("barks"),
                "makeSound() do Dog precisa conter 'barks' na saída");
    }

    @Test
    @DisplayName("Dog.sleep() deve ser sobrescrito em Dog")
    void dog_sleep_overridden() throws Exception {
        Class<?> dogClass = Class.forName("model.Dog");
        Method method = dogClass.getMethod("sleep");
        assertEquals(dogClass, method.getDeclaringClass(),
                "sleep() precisa ser sobrescrito em Dog, não apenas herdado de Animal");
    }

    @Test
    @DisplayName("Dog deve ter sobrecarga move(String direction)")
    void dog_move_overload_string() throws Exception {
        Class<?> dogClass = Class.forName("model.Dog");
        assertDoesNotThrow(() -> dogClass.getMethod("move", String.class),
                "Dog precisa ter o método move(String direction)");
    }

    @Test
    @DisplayName("Dog deve ter sobrecarga move(int, String)")
    void dog_move_overload_int_string() throws Exception {
        Class<?> dogClass = Class.forName("model.Dog");
        assertDoesNotThrow(() -> dogClass.getMethod("move", int.class, String.class),
                "Dog precisa ter o método move(int distance, String item)");
    }

    @Test
    @DisplayName("Dog deve ter o método fetch(String item)")
    void dog_fetch() throws Exception {
        Class<?> dogClass = Class.forName("model.Dog");
        assertDoesNotThrow(() -> dogClass.getMethod("fetch", String.class),
                "Dog precisa ter o método fetch(String item)");
    }

    // -------------------------------------------------------------------------
    // Cat — herança, construtor e métodos
    // -------------------------------------------------------------------------

    @Test
    @DisplayName("Cat deve estender Animal")
    void cat_extendsAnimal() throws Exception {
        Class<?> cat = Class.forName("model.Cat");
        Class<?> animal = Class.forName("model.Animal");
        assertTrue(animal.isAssignableFrom(cat), "Cat precisa usar 'extends Animal'");
    }

    @Test
    @DisplayName("Cat deve ter construtor com os atributos corretos")
    void cat_constructor() throws Exception {
        Class<?> catClass = Class.forName("model.Cat");
        Class<?> furColorClass = Class.forName("enums.FurColor");

        Constructor<?> constructor = assertDoesNotThrow(() -> catClass.getConstructor(
                String.class, int.class, double.class,
                furColorClass, boolean.class, String.class, int.class, boolean.class),
                "Cat precisa ter construtor com: name, age, weight, furColor, isIndoor, favoriteFood, purringFrequency, isNeutered");
        assertNotNull(constructor);
    }

    @Test
    @DisplayName("Cat.makeSound() deve conter 'Meow' na saída")
    void cat_makeSound() throws Exception {
        Class<?> catClass = Class.forName("model.Cat");
        Class<?> furColorClass = Class.forName("enums.FurColor");

        Object[] furColors = furColorClass.getEnumConstants();
        assertNotNull(furColors, "FurColor não possui constantes");
        assertTrue(furColors.length > 0, "FurColor precisa ter constantes implementadas antes de testar Cat");

        Constructor<?> ctor = catClass.getConstructor(
                String.class, int.class, double.class,
                furColorClass, boolean.class, String.class, int.class, boolean.class);
        Object cat = ctor.newInstance("Whiskers", 2, 4.5, furColors[0], true, "Tuna", 25, false);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        catClass.getMethod("makeSound").invoke(cat);
        System.setOut(System.out);

        assertTrue(out.toString().contains("Meow"),
                "makeSound() do Cat precisa conter 'Meow' na saída");
    }

    @Test
    @DisplayName("Cat.sleep() deve ser sobrescrito em Cat")
    void cat_sleep_overridden() throws Exception {
        Class<?> catClass = Class.forName("model.Cat");
        Method method = catClass.getMethod("sleep");
        assertEquals(catClass, method.getDeclaringClass(),
                "sleep() precisa ser sobrescrito em Cat, não apenas herdado de Animal");
    }

    @Test
    @DisplayName("Cat deve ter sobrecarga move(int distance, int speed)")
    void cat_move_overload_int_int() throws Exception {
        Class<?> catClass = Class.forName("model.Cat");
        assertDoesNotThrow(() -> catClass.getMethod("move", int.class, int.class),
                "Cat precisa ter o método move(int distance, int speed)");
    }

    @Test
    @DisplayName("Cat deve ter sobrecarga move(int distance, String target)")
    void cat_move_overload_int_string() throws Exception {
        Class<?> catClass = Class.forName("model.Cat");
        assertDoesNotThrow(() -> catClass.getMethod("move", int.class, String.class),
                "Cat precisa ter o método move(int distance, String target)");
    }

    @Test
    @DisplayName("Cat deve ter o método purr() com saída contendo 'purring'")
    void cat_purr() throws Exception {
        Class<?> catClass = Class.forName("model.Cat");
        Class<?> furColorClass = Class.forName("enums.FurColor");

        Object[] furColors = furColorClass.getEnumConstants();
        assertNotNull(furColors, "FurColor não possui constantes");
        assertTrue(furColors.length > 0, "FurColor precisa ter constantes implementadas antes de testar Cat");

        Constructor<?> ctor = catClass.getConstructor(
                String.class, int.class, double.class,
                furColorClass, boolean.class, String.class, int.class, boolean.class);
        Object cat = ctor.newInstance("Whiskers", 2, 4.5, furColors[0], true, "Tuna", 25, false);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        catClass.getMethod("purr").invoke(cat);
        System.setOut(System.out);

        assertTrue(out.toString().contains("purring"),
                "purr() do Cat precisa conter 'purring' na saída");
    }

    @Test
    @DisplayName("Cat.loseLife() deve decrementar vidas e exibir o número restante")
    void cat_loseLife() throws Exception {
        Class<?> catClass = Class.forName("model.Cat");
        Class<?> furColorClass = Class.forName("enums.FurColor");

        Object[] furColors = furColorClass.getEnumConstants();
        assertNotNull(furColors, "FurColor não possui constantes");
        assertTrue(furColors.length > 0, "FurColor precisa ter constantes implementadas antes de testar Cat");

        Constructor<?> ctor = catClass.getConstructor(
                String.class, int.class, double.class,
                furColorClass, boolean.class, String.class, int.class, boolean.class);
        Object cat = ctor.newInstance("Whiskers", 2, 4.5, furColors[0], true, "Tuna", 25, false);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        catClass.getMethod("loseLife").invoke(cat);
        System.setOut(System.out);

        String output = out.toString();
        assertTrue(output.contains("6") || output.toLowerCase().contains("lives"),
                "loseLife() precisa exibir o número de vidas restantes após perder uma vida (gato começa com 7)");
    }
}
