package pl.edu.wszib.book.store.dao;

import pl.edu.wszib.book.store.model.Order;

import java.util.Optional;

public interface IOrderDAO {
    void persist(Order order);
    Optional<Order> getOrderById(int id);
}
