package mapper;

import domain.Order;

import java.util.List;

public interface OrderMapper {

    List<Order> findAll();
}
