package repositories;

import domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>, JpaSpecificationExecutor<Customer> {
    List<Customer> findAll();
    List<Customer> findByAddressZip(String zip);
    List<Customer> findDistinctByOrdersOrderlinesProductTypeAndOrdersOrderlinesProductName(String type,String name);
    List<Customer> getAllCustomersFromCountry(@Param("country") String country);
    @Query("select c.firstname, c.lastname from Customer c where LOWER(c.address.city)=LOWER(:city)")
    List<Object[]> getFirstAndLastNameOfCustomerFromCity(@Param("city") String city);
}
