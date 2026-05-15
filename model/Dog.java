package model;

import enums.Habitat;
import enums.TrainingLevel;

public class Dog extends Animal {

    private String breed;
    private boolean isVaccinated;
    private TrainingLevel trainingLevel;
    private String ownerName;
    private int barkVolume; // decibels

    // Construtor da classe cachorro
    // Chama os atributos da classe animal pelo metodo super()
    // Inclua os atributos especificos da classe

    // OVERRIDE: different sound behavior
    @Override
    public void makeSound() {
        System.out.println(getName() + " barks: Woof woof! (" + barkVolume + " dB)");
    }

    // OVERRIDE: comportamento de dormir diferente

    // Herdado do animal: move( int distancia )

    // OVERLOAD: anda em uma direção especifica
    public void move(String direction) {
        System.out.println(getName() + " ran towards the " + direction + ".");
    }

    // OVERLOAD: anda e pega um objeto ( parametros: distancia e objeto a ser pego )

    // Metodo fetch ( parametro:item )

    // Override de display info, com super.displayInfo() + os atributos da classe dog

    // Getters

}
