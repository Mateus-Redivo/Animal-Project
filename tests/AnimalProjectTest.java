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

        for (int i = 0; i < constants.length; i++) {
            Method getCode = cls.getMethod("getCode");
            int code = (int) getCode.invoke(constants[i]);
            Object result = fromCode.invoke(null, code);
            assertEquals(constants[i], result,
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

    // -------------------------------------------------------------------------
    // Dog — herança e construtor
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
        Class<?> habitatClass = Class.forName("enums.Habitat");
        Class<?> trainingClass = Class.forName("enums.TrainingLevel");

        Constructor<?> constructor = assertDoesNotThrow(() -> dogClass.getConstructor(
                String.class, int.class, int.class, double.class,
                habitatClass, boolean.class,
                String.class, boolean.class, trainingClass, String.class, int.class),
                "Dog precisa ter construtor com: name, speed, age, weight, habitat, isWild, breed, isVaccinated, trainingLevel, ownerName, barkVolume");
        assertNotNull(constructor);
    }

    @Test
    @DisplayName("Dog.makeSound() deve conter 'barks' na saída")
    void dog_makeSound() throws Exception {
        Class<?> dogClass = Class.forName("model.Dog");
        Class<?> habitatClass = Class.forName("enums.Habitat");
        Class<?> trainingClass = Class.forName("enums.TrainingLevel");

        Object habitat = Enum.valueOf((Class<Enum>) habitatClass, "DOMESTIC");
        Object training = trainingClass.getEnumConstants()[0];

        Constructor<?> ctor = dogClass.getConstructor(
                String.class, int.class, int.class, double.class,
                habitatClass, boolean.class,
                String.class, boolean.class, trainingClass, String.class, int.class);
        Object dog = ctor.newInstance("Rex", 30, 3, 15.0, habitat, false, "Labrador", true, training, "João", 75);

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

}