package app.repositories;

import app.domain.company.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long> {
    @Query("select a.street from Address a where a.zip=:zip and a.city=:city")
    List<String> findStreetByCityAndZip(@Param("city") String city, @Param("zip") String zip);
//    List<String> findStreetByCityAndZip(String city, String zip);
}
