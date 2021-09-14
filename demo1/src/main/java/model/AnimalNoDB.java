package model;

import java.io.Serializable;

public class AnimalNoDB implements Serializable {
    private String animal;
    private String sound;


    public AnimalNoDB(String animal, String sound) {
        this.animal = animal;
        this.sound = sound;
    }
}
