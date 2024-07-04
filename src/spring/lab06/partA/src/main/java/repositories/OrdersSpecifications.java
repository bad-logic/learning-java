package repositories;

import domain.Order;
import org.springframework.data.jpa.domain.Specification;

public class OrdersSpecifications {
    public static Specification<Order> withStatusClosed(){
        return (root,query,criteriaBuilder) -> criteriaBuilder.equal(root.get("status"),"closed");
    }
}
