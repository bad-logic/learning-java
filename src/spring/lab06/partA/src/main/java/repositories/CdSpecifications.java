package repositories;

import domain.Cd;
import org.springframework.data.jpa.domain.Specification;

public class CdSpecifications {
    public static Specification<Cd> byArtist(String artist){
        return (root,query,criteriaBuilder)->criteriaBuilder.equal(criteriaBuilder.lower(root.get("artist")),artist.toLowerCase());
    }

    public static Specification<Cd> hasPriceGreaterThan(double price){
        return (root,query,criteriaBuilder)-> criteriaBuilder.greaterThan(root.get("price"),price);
    }
}
