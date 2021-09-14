package facade;

import entity.Customer;
import entity.ItemType;
import entity.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class CustomerFacade {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    private static CustomerFacade instance;


    public static CustomerFacade getCustomerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CustomerFacade();
        }
        return instance;
    }

    public void createCustomer(Customer customer) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Customer findCustomerByEmail(String email) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c WHERE c.email =:email", Customer.class);
            query.setParameter("email", email);
            Customer customer = query.getSingleResult();
            return customer;

        } finally {
            em.close();
        }
    }


    public List<Customer> getAllCustomers() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c", Customer.class);
            List<Customer> cList = query.getResultList();
            return cList;
        } finally {
            em.close();
        }
    }

    public void createItemType(ItemType itemType) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(itemType);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void createOrder(Customer customer, Order order) {
        EntityManager em = emf.createEntityManager();
        try {
            customer.addOrders(order);
            em.persist(customer);

        } finally {
            em.close();
        }
    }
}


