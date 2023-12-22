package pl.edu.wszib.book.store.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.book.store.dao.IBookDAO;
import pl.edu.wszib.book.store.model.Book;
import pl.edu.wszib.book.store.services.IBookService;

import java.util.List;

@Service
public class BookService implements IBookService {

    @Autowired
    IBookDAO bookDAO;

    @Override
    public List<Book> getAll() {
        return this.bookDAO.getAll();
    }
}
