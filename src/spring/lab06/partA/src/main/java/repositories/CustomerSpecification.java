package repositories;

import domain.Customer;
import org.springframework.data.jpa.domain.Specification;

public class CustomerSpecification {
    public static Specification<Customer> whoLiveInAmsterdam() {
        return (root,query,criteriaBuilder) -> criteriaBuilder.equal(  criteriaBuilder.lower(root.get("address").get("city")),"amsterdam");
    }
}
