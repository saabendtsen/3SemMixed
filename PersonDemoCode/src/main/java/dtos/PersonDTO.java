package dtos;

import entities.Person;

import java.util.Date;

public class PersonDTO {

    private int id;
    private String firstName;
    private String lastName;
    private String phone;


    public PersonDTO(Person person) {
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.phone = person.getPhone();
        this.id = person.getId();

    }


    public PersonDTO(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }
}


