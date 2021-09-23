package facades;

import dtos.PersonDTO;
import dtos.PersonsDTO;
import entities.Person;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class PersonFacade implements IPersonFacade {

    private static PersonFacade instance;
    private static EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();


    public PersonFacade() {
    }

    public static PersonFacade getPersonFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PersonFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }


    @Override
    public PersonDTO addPerson(String fname, String Lname, String phone) {
        EntityManager em = getEntityManager();
        PersonDTO personDTO = new PersonDTO(fname,Lname,phone);
        Person person = new Person(personDTO);

        try {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
            return new PersonDTO(person);
        }finally {
            em.close();
        }

    }

    @Override
    public PersonDTO deletePerson(int id) {
       EntityManager em = getEntityManager();
       try{
           em.getTransaction().begin();
           Person person = em.find(Person.class,id);
           em.remove(person);
           return null;
       }

    }

    @Override
    public PersonDTO getPerson(int id) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p WHERE p.id=:id", Person.class);
            query.setParameter("id", id);
            Person res = query.getSingleResult();
            System.out.println(res);
            return new PersonDTO(res);
        } finally {
            em.close();
        }
    }

    @Override
    public PersonsDTO getAllPersons() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);
            List<Person> res = query.getResultList();
            System.out.println(res);
            return new PersonsDTO(res);
        } finally {
            em.close();
        }
    }

    @Override
    public PersonDTO editPerson(PersonDTO p) {
        EntityManager em = getEntityManager();
        try {
            Person person = new Person(p);
            em.getTransaction().begin();
            em.merge(person);
            em.getTransaction().commit();
            Person person1 = em.find(Person.class,p.getId());
            return new PersonDTO(person1);
        }finally {
            em.close();
        }
    }
}
