package repositories;

import domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Integer> {
    @Query(value = "SELECT * FROM Address  a WHERE LOWER(a.city)='amsterdam'", nativeQuery = true)
    List<Address> getAllAddressesFromAmsterdam();
}
