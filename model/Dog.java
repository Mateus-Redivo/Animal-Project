package model;

import enums.TrainingLevel;
import enums.Habitat;

public class Dog extends Animal {

    private String breed;
    private boolean isVaccinated;
    private TrainingLevel trainingLevel;
    private String ownerName;
    private int barkVolume; // decibels

    public Dog(String name, int age, double weight, String breed,
               boolean isVaccinated, TrainingLevel trainingLevel,
               String ownerName, int barkVolume) {
        super(name, 48, age, weight, Habitat.DOMESTIC, false);
        this.breed = breed;
        this.isVaccinated = isVaccinated;
        this.trainingLevel = trainingLevel;
        this.ownerName = ownerName;
        this.barkVolume = barkVolume;
    }

    // OVERRIDE: different sound behavior
    @Override
    public void makeSound() {
        System.out.println(getName() + " barks: Woof woof! (" + barkVolume + " dB)");
    }

    // OVERRIDE: different sleep behavior
    @Override
    public void sleep() {
        System.out.println(getName() + " curls up and sleeps next to " + ownerName + ".");
    }

    // Inherited from Animal: move(int distance)

    // OVERLOAD: move in a specific direction
    public void move(String direction) {
        System.out.println(getName() + " ran towards the " + direction + ".");
    }

    // OVERLOAD: move and fetch an object
    public void move(int distance, String fetchTarget) {
        System.out.println(getName() + " sprinted " + distance +
                           " meters to fetch the " + fetchTarget + "!");
    }

    public void fetch(String item) {
        System.out.println(getName() + " fetched the " + item + " and brought it back!");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Breed:          " + breed);
        System.out.println("Vaccinated:     " + (isVaccinated ? "Yes" : "No"));
        System.out.println("Training level: " + trainingLevel.getDisplayName());
        System.out.println("Owner:          " + ownerName);
        System.out.println("Bark volume:    " + barkVolume + " dB");
    }

    // Getters
    public String getBreed()                { return breed; }
    public boolean isVaccinated()           { return isVaccinated; }
    public TrainingLevel getTrainingLevel() { return trainingLevel; }
    public String getOwnerName()            { return ownerName; }
    public int getBarkVolume()              { return barkVolume; }
}
