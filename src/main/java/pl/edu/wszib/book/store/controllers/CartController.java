package pl.edu.wszib.book.store.controllers;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.book.store.dao.IBookDAO;
import pl.edu.wszib.book.store.model.Book;
import pl.edu.wszib.book.store.model.OrderPosition;
import pl.edu.wszib.book.store.session.SessionObject;

import java.util.Optional;

@Controller
public class CartController {

    @Autowired
    IBookDAO bookDAO;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(path = "/book/add/{bookId}", method = RequestMethod.GET)
    public String addBook(@PathVariable final int bookId) {
        Optional<Book> bookBox = this.bookDAO.getById(bookId);
        bookBox.ifPresent(book -> this.sessionObject.getCart().stream()
                .filter(op -> op.getBook().getId() == bookId)
                .findFirst()
                .ifPresentOrElse(
                        OrderPosition::incrementQuantity,
                        () -> this.sessionObject.getCart()
                                .add(new OrderPosition(book, 1))));
        return "redirect:/main";
    }
}
