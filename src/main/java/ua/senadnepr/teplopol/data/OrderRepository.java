package ua.senadnepr.teplopol.data;

import org.springframework.data.repository.CrudRepository;
import ua.senadnepr.teplopol.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
