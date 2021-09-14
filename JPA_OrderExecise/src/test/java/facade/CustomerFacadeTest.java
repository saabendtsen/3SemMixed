package facade;

import entity.Customer;
import entity.ItemType;
import entity.Order;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerFacadeTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    CustomerFacade cf = CustomerFacade.getCustomerFacade(emf);
    List<Customer> excpetedCustomerList = new ArrayList<>();


    @BeforeEach
    void setUp() {
        EntityManager em = emf.createEntityManager();
        Customer c1 = new Customer("Kresten","Kresten@email.dk");
        Customer c2 = new Customer("Arne","Arne@email.dk");
        Customer c3 = new Customer("Niller","Niller@email.dk");
        Customer c4 = new Customer("Carsten","Carsten@email.dk");

        excpetedCustomerList.add(c1);
        excpetedCustomerList.add(c2);
        excpetedCustomerList.add(c3);
        excpetedCustomerList.add(c4);

        ItemType it1 = new ItemType("Volvo","Det er en bil",230000);
        ItemType it2 = new ItemType("BMW","Det er en bil",350000);




        em.getTransaction().begin();
        em.persist(c1);
        em.persist(c2);
        em.persist(c3);
        em.persist(c4);
        em.persist(it1);
        em.persist(it2);

        em.getTransaction().commit();

    }

    @AfterEach
    void tearDown() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
       // em.createNamedQuery("Customer.deleteAllRows").executeUpdate();

    }

    @Test
    void createCustomer() {
        Customer customer = new Customer("Mikkel","Mikkel@email.dk");
        cf.createCustomer(customer);
        Customer actualCustomer = cf.findCustomerByEmail("Mikkel@email.dk");
        assertEquals(customer.getId(), actualCustomer.getId());
    }


    @Test
    void getAllCustomers() {
        List<Customer> actualCustomerList =  cf.getAllCustomers();
        assertEquals(excpetedCustomerList.size(),actualCustomerList.size());
    }

    @Test
    void createOrder(){
        Order order = new Order();

    }
}