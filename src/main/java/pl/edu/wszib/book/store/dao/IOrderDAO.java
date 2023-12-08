package pl.edu.wszib.book.store.dao;

import pl.edu.wszib.book.store.model.Order;

public interface IOrderDAO {
    void persist(Order order);
}
