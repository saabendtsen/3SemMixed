package enitity;

import javax.persistence.*;

@Table(name = "animal")
@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;
    private String animal;
    private String sound;

    public Animal(String animal, String sound) {
        this.animal = animal;
        this.sound = sound;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public Animal() {
    }

    public Long getId() {
        return pid;
    }

    public void setId(Long id) {
        this.pid = id;
    }
}