package repositories;


import domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer>, JpaSpecificationExecutor<Order> {
    @Query("select o.ordernr from Order o where o.status='closed'")
    List<String> getOrderNumbersOfClosedOrders();

    @Query("select o.ordernr from Order o where LOWER(o.customer.address.city)=LOWER(:city)")
    List<String> getOrderNumberOfCustomersFromCity(@Param("city") String city);
}
