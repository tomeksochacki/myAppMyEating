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
            /*switch (user.getRole()) {
                case ADMIN:
                    return "redirect:/main-admin";
                break;
                case COURIER:
                    return "redirect:/main-courier";
                break;
                case CUSTOMER:
                    return "redirect:/main";
                break;
                case MANUFACTURER:
                    return "redirect:/main-manufacturer";
                break;
            }*/

            /*if (user.getRole() == User.Role.ADMIN) {
                return "redirect:/main-admin";
            } else if (user.getRole() == User.Role.COURIER) {
                return "redirect:/main-courier";
            } else if (user.getRole() == User.Role.MANUFACTURER) {
                return "redirect:/main-manufacturer";
            } else if (user.getRole() == User.Role.CUSTOMER) {
                return "redirect:/main";
            }*/
            //TODO sprawidzić czy tu zamiast == nie powinno być equals w tych wszystkich else if-ach
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
