package database;
import domain.Customer;
import exceptions.RecordNotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
public class CustomerDA {
    private static ArrayList<Customer> customers = new ArrayList<Customer>(5);
    
    public static void add(Customer c) {
        customers.add(c);
    }
    
    public static ArrayList<Customer> getCustomers() {
        return customers;
    }
    
    public static Customer find(String uid) throws RecordNotFoundException{
        Customer customer = null;
        System.out.println("Inside CustomerDA.find");
        
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        System.out.println("em = " + em);
        
        String sql = "SELECT c FROM Customer c " +
                     "WHERE c.userID = :u";
        TypedQuery<Customer> query = em.createQuery(sql,Customer.class);
        query.setParameter("u", uid);
        System.out.println("query = " + query);
        
        try {
            customer = query.getSingleResult();
            System.out.println("customer = " + customer);
        }
        
        catch(NoResultException e) {
            RecordNotFoundException ex = new RecordNotFoundException("Customer " + uid + " not found");
            throw ex;
        }
        

        catch (Exception e) {
            System.out.println("****EXCEPTION*****   " + e.getMessage());
        }
        
        finally {
            em.close();
        }
        return customer;
    }
    
    public static void inititialize() {
     }
}
