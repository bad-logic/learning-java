package bank.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import bank.domain.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
    default void saveCustomer(Customer customer) {
        if(customer.getId()==14){
            throw new RuntimeException("could not save customer "+customer.getId());
        }
        save(customer);
    }
}




