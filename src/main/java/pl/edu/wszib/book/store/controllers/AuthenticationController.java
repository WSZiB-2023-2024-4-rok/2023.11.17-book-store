package pl.edu.wszib.book.store.controllers;

import jakarta.annotation.Resource;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.book.store.dao.IUserDAO;
import pl.edu.wszib.book.store.model.User;
import pl.edu.wszib.book.store.session.SessionObject;

import java.util.Optional;

@Controller
public class AuthenticationController {

    @Autowired
    private IUserDAO userDAO;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("userModel", new User());
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        return "login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute User user) {
        Optional<User> userBox = this.userDAO.getByLogin(user.getLogin());
        if(userBox.isPresent() &&
                userBox.get().getPassword().equals(DigestUtils.md5Hex(user.getPassword()))) {
            this.sessionObject.setLoggedUser(userBox.get());
        }
        return "redirect:/main";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public String logout() {
        this.sessionObject.setLoggedUser(null);
        return "redirect:/main";
    }
}
