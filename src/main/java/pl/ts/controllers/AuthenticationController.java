package pl.ts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.ts.database.Database;
import pl.ts.validators.LoginValidator;

@Controller
public class AuthenticationController {

    @Autowired
    Database database;

    private String info;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginFrom(Model model) {
        model.addAttribute("info", this.info);
        this.info = null;
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String login, @RequestParam String password) {
        if (!LoginValidator.validateLogin(login) || !LoginValidator.validatePassword(password)) {
            this.info = "Logowanie nieudane !!";
            return "redirect:/login";
        }

        if (database.authenticate(login, password)) {
            return "redirect:/main";
        } else {
            this.info = "Logowanie nieudane !!";
            return "redirect:/login";
        }
    }
}
