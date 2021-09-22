package facades;

import dtos.PersonDTO;
import dtos.PersonsDTO;

import java.util.List;

public interface IPersonFacade {
    public PersonDTO addPerson(String fName, String lName, String phone);
    public PersonDTO deletePerson(int id);
    public PersonDTO getPerson(int id);
    public PersonsDTO getAllPersons();
    public PersonDTO editPerson(PersonDTO p);
}


