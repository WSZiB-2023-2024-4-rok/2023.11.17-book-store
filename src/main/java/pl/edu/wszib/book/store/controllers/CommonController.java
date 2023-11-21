package pl.edu.wszib.book.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.book.store.dao.IBookDAO;
import pl.edu.wszib.book.store.model.Book;

import java.util.List;

@Controller
public class CommonController {

    @Autowired
    IBookDAO bookDAO;

    @RequestMapping(path = {"/", "/main", "/index"}, method = RequestMethod.GET)
    public String main(Model model) {
        model.addAttribute("books", bookDAO.getAll());
        return "index";
    }

    @RequestMapping(path = "/contact", method = RequestMethod.GET)
    public String contact() {
        return "contact";
    }
}
