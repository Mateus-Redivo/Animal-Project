import enums.FurColor;
import enums.Habitat;
import enums.TrainingLevel;
import model.Cat;
import model.Dog;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalProjectTest {

    // -------------------------------------------------------------------------
    // TrainingLevel enum
    // -------------------------------------------------------------------------

    @Test
    @DisplayName("TrainingLevel deve ter as 4 constantes definidas")
    void trainingLevel_constants() {
        TrainingLevel[] values = TrainingLevel.values();
        assertEquals(4, values.length,
            "TrainingLevel precisa ter exatamente 4 constantes: BEGINNER, INTERMEDIATE, ADVANCED, PROFESSIONAL");
    }

    @Test
    @DisplayName("TrainingLevel.getDisplayName() deve retornar o nome correto")
    void trainingLevel_displayName() {
        assertEquals("Beginner",     TrainingLevel.BEGINNER.getDisplayName());
        assertEquals("Intermediate", TrainingLevel.INTERMEDIATE.getDisplayName());
        assertEquals("Advanced",     TrainingLevel.ADVANCED.getDisplayName());
        assertEquals("Professional", TrainingLevel.PROFESSIONAL.getDisplayName());
    }

    @Test
    @DisplayName("TrainingLevel.fromCode() deve retornar a constante correta")
    void trainingLevel_fromCode() {
        assertEquals(TrainingLevel.BEGINNER,     TrainingLevel.fromCode(1));
        assertEquals(TrainingLevel.INTERMEDIATE, TrainingLevel.fromCode(2));
        assertEquals(TrainingLevel.ADVANCED,     TrainingLevel.fromCode(3));
        assertEquals(TrainingLevel.PROFESSIONAL, TrainingLevel.fromCode(4));
    }

    @Test
    @DisplayName("TrainingLevel.fromCode() deve lançar exceção para código inválido")
    void trainingLevel_fromCode_invalid() {
        assertThrows(IllegalArgumentException.class, () -> TrainingLevel.fromCode(99));
    }

    // -------------------------------------------------------------------------
    // FurColor enum
    // -------------------------------------------------------------------------

    @Test
    @DisplayName("FurColor deve ter as 7 constantes definidas")
    void furColor_constants() {
        FurColor[] values = FurColor.values();
        assertEquals(7, values.length,
            "FurColor precisa ter exatamente 7 constantes: BLACK, WHITE, ORANGE_TABBY, GRAY, BROWN, CALICO, SPOTTED");
    }

    // -------------------------------------------------------------------------
    // Dog — herança e construtor
    // -------------------------------------------------------------------------

    @Test
    @DisplayName("Dog deve estender Animal")
    void dog_extendsAnimal() {
        assertTrue(model.Animal.class.isAssignableFrom(Dog.class),
            "Dog precisa usar 'extends Animal'");
    }

    @Test
    @DisplayName("Dog deve ser instanciado corretamente com super()")
    void dog_constructor() {
        Dog dog = new Dog("Rex", 30, 3, 15.0, Habitat.DOMESTIC, false,
                          "Labrador", true, TrainingLevel.INTERMEDIATE, "João", 80);
        assertEquals("Rex", dog.getName());
        assertEquals(3,     dog.getAge());
        assertEquals(15.0,  dog.getWeight());
    }

    @Test
    @DisplayName("Dog.makeSound() deve conter 'barks' na saída")
    void dog_makeSound() {
        Dog dog = new Dog("Rex", 30, 3, 15.0, Habitat.DOMESTIC, false,
                          "Labrador", true, TrainingLevel.BEGINNER, "João", 75);
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));
        dog.makeSound();
        System.setOut(System.out);
        assertTrue(out.toString().contains("barks"),
            "makeSound() do Dog precisa conter 'barks'");
    }

    @Test
    @DisplayName("Dog.sleep() deve ser sobrescrito com comportamento diferente de Animal")
    void dog_sleep_overridden() throws Exception {
        var method = Dog.class.getMethod("sleep");
        assertEquals(Dog.class, method.getDeclaringClass(),
            "sleep() precisa ser sobrescrito em Dog, não apenas herdado de Animal");
    }

    @Test
    @DisplayName("Dog.move(String) deve existir como sobrecarga")
    void dog_move_overload_string() throws Exception {
        assertDoesNotThrow(() -> Dog.class.getMethod("move", String.class),
            "Dog precisa ter o método move(String direction)");
    }

    @Test
    @DisplayName("Dog.move(int, String) deve existir como sobrecarga")
    void dog_move_overload_int_string() throws Exception {
        assertDoesNotThrow(() -> Dog.class.getMethod("move", int.class, String.class),
            "Dog precisa ter o método move(int distance, String item)");
    }

    @Test
    @DisplayName("Dog.fetch() deve existir")
    void dog_fetch() throws Exception {
        assertDoesNotThrow(() -> Dog.class.getMethod("fetch", String.class),
            "Dog precisa ter o método fetch(String item)");
    }

    // -------------------------------------------------------------------------
    // Cat — herança e construtor
    // -------------------------------------------------------------------------

    @Test
    @DisplayName("Cat deve estender Animal")
    void cat_extendsAnimal() {
        assertTrue(model.Animal.class.isAssignableFrom(Cat.class),
            "Cat precisa usar 'extends Animal'");
    }

    @Test
    @DisplayName("Cat deve ser instanciado corretamente com super()")
    void cat_constructor() {
        Cat cat = new Cat("Mia", 15, 2, 4.5, Habitat.DOMESTIC, false,
                          FurColor.GRAY, true);
        assertEquals("Mia", cat.getName());
        assertEquals(2,     cat.getAge());
        assertEquals(4.5,   cat.getWeight());
    }

    @Test
    @DisplayName("Cat.makeSound() deve ser sobrescrito com comportamento diferente de Animal")
    void cat_makeSound_overridden() throws Exception {
        var method = Cat.class.getMethod("makeSound");
        assertEquals(Cat.class, method.getDeclaringClass(),
            "makeSound() precisa ser sobrescrito em Cat");
    }

    @Test
    @DisplayName("Cat.displayInfo() deve chamar super.displayInfo()")
    void cat_displayInfo_callsSuper() {
        Cat cat = new Cat("Mia", 15, 2, 4.5, Habitat.DOMESTIC, false,
                          FurColor.GRAY, true);
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));
        cat.displayInfo();
        System.setOut(System.out);
        String output = out.toString();
        assertTrue(output.contains("Name:"),    "displayInfo() deve imprimir o campo Name (herdado via super)");
        assertTrue(output.contains("Habitat:"), "displayInfo() deve imprimir o campo Habitat (herdado via super)");
    }
}
