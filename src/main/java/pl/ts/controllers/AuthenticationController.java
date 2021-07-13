package pl.ts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.ts.database.Database;
import pl.ts.model.User;
import pl.ts.session.SessionObject;
import pl.ts.validators.LoginValidator;

import javax.annotation.Resource;

@Controller
public class AuthenticationController {

    @Autowired
    Database database;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginFrom(Model model) {
        model.addAttribute("info", this.sessionObject.getInfo());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String login, @RequestParam String password) {
        if (!LoginValidator.validateLogin(login) || !LoginValidator.validatePassword(password)) {
            this.sessionObject.setInfo("Logowanie nieudane !!");
            return "redirect:/login";
        }

        User user = database.authenticate(login, password);
        if (user != null) {
            sessionObject.setUser(user);
            return "redirect:/main";
        } else {
            this.sessionObject.setInfo("Logowanie nieudane !!");
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model) {
        this.sessionObject.logoutUser();
        return "redirect:/";
    }
}
