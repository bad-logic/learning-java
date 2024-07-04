package repositories;

import domain.Cd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CdRepository extends JpaRepository<Cd,Integer>, JpaSpecificationExecutor<Cd> {
    List<Cd> findByArtistAndPriceLessThan(String artist, double price);
    List<Cd> getAllCdsFromArtist(@Param("artist") String artist);

    @Query("select c from Cd c where LOWER(c.artist)=LOWER(:artist) and c.price > :price")
    List<Cd> getAllCdsByArtistAndPriceGreaterThan(@Param("artist") String artist, @Param("price") double price);

    @Query(value = "select * from product c where LOWER(c.artist)='u2'",nativeQuery = true)
    List<Cd> getAllCdsByArtistU2();
}