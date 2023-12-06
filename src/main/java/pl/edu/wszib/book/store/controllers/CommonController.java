package pl.edu.wszib.book.store.controllers;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.book.store.dao.IBookDAO;
import pl.edu.wszib.book.store.model.Book;
import pl.edu.wszib.book.store.session.SessionObject;

import java.util.List;

@Controller
public class CommonController {

    @Autowired
    private IBookDAO bookDAO;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(path = {"/", "/main", "/index"}, method = RequestMethod.GET)
    public String main(Model model) {
        model.addAttribute("books", bookDAO.getAll());
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        return "index";
    }

    @RequestMapping(path = "/contact", method = RequestMethod.GET)
    public String contact(Model model) {
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        return "contact";
    }
}
