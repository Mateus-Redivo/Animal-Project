package model;

/*
 * ATIVIDADE — Classe Cat
 *
 * Crie a classe Cat seguindo o mesmo modelo da classe Dog,
 * que foi criada para o cachorro.
 *
 * ------------------------------------------------------------
 * 1. HERANÇA
 *    Cat deve estender a classe Animal.
 *
 * ------------------------------------------------------------
 * 2. CAMPOS (atributos privados)
 *    Declare os seguintes campos:
 *      - lives             (int)     — número de vidas do gato
 *      - furColor          (FurColor) — cor do pelo (use o enum FurColor)
 *      - isIndoor          (boolean) — se é gato de interior
 *      - favoriteFood      (String)  — comida favorita
 *      - purringFrequency  (int)     — frequência de ronronar em Hz
 *      - isNeutered        (boolean) — se é castrado
 *
 *    Lembre-se de importar o enum FurColor e a classe Habitat.
 *
 * ------------------------------------------------------------
 * 3. CONSTRUTOR
 *    Crie o construtor recebendo:
 *      (String name, int age, double weight, FurColor furColor,
 *       boolean isIndoor, String favoriteFood,
 *       int purringFrequency, boolean isNeutered)
 *
 *    Chame o construtor da superclasse com:
 *      super(name, 30, age, weight,
 *            isIndoor ? Habitat.DOMESTIC : Habitat.URBAN,
 *            !isIndoor)
 *
 *    Inicialize o campo lives com 7.
 *    Inicialize os demais campos com os parâmetros recebidos.
 *
 * ------------------------------------------------------------
 * 4. OVERRIDE — makeSound()
 *    Sobrescreva o método makeSound() de Animal.
 *    A saída deve conter o nome do gato, a palavra "Meow" e
 *    a frequência de ronronar em Hz.
 *    Exemplo: "Whiskers says: Meow! (purring at 25 Hz)"
 *
 * ------------------------------------------------------------
 * 5. OVERRIDE — sleep()
 *    Sobrescreva o método sleep() de Animal.
 *    A saída deve indicar que o gato procura o lugar mais quente
 *    e dorme por 14 horas.
 *    Exemplo: "Whiskers finds the warmest spot and sleeps for 14 hours."
 *
 * ------------------------------------------------------------
 * 6. OVERLOAD — move (sobrecargas)
 *    O método move(int distance) já está herdado de Animal.
 *    Crie duas novas versões sobrecarregadas:
 *
 *    a) move(int distance, int speed)
 *       Imprime que o gato deu um salto de 'distance' metros
 *       a 'speed' km/h.
 *       Exemplo: "Whiskers leaped 3 meters at 40 km/h."
 *
 *    b) move(int distance, String target)
 *       Imprime que o gato se aproximou silenciosamente de
 *       'target' por 'distance' metros.
 *       Exemplo: "Whiskers silently stalked 2 meters toward the mouse."
 *
 * ------------------------------------------------------------
 * 7. MÉTODO purr()
 *    Crie um método público purr() que imprime o nome do gato
 *    e sua frequência de ronronar.
 *    Exemplo: "Whiskers is purring at 25 Hz... purrr~"
 *
 * ------------------------------------------------------------
 * 8. MÉTODO loseLife()
 *    Crie um método público loseLife() que:
 *      - Se lives > 0: decrementa lives e imprime quantas vidas restam.
 *        Exemplo: "Whiskers lost a life! Lives remaining: 6"
 *      - Senão: imprime que o gato não tem mais vidas.
 *        Exemplo: "Whiskers has no lives left."
 *
 * ------------------------------------------------------------
 * 9. OVERRIDE — displayInfo()
 *    Sobrescreva displayInfo() chamando super.displayInfo() primeiro
 *    e depois imprimindo os campos específicos do gato:
 *      - lives, furColor (use getDisplayName()), isIndoor,
 *        favoriteFood, purringFrequency e isNeutered.
 *
 * ------------------------------------------------------------
 * 10. GETTERS
 *    Implemente getters para todos os campos:
 *      getLives(), getFurColor(), isIndoor(), getFavoriteFood(),
 *      getPurringFrequency(), isNeutered()
 */

public class Cat {

}