package pl.ts.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.ts.database.Database;
import pl.ts.model.Dish;
import pl.ts.session.SessionObject;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    Database database;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String addOrder(Model model) {
        List<Dish> dishes = this.database.getDishes();
        model.addAttribute("dishes", dishes);
        model.addAttribute("logged", this.sessionObject.isLogged());
        model.addAttribute("role",
                this.sessionObject.getUser() != null ? this.sessionObject.getUser().getRole() : null);
        return "addorder";
    }

    @RequestMapping(value = "/pricerange", method = RequestMethod.GET)
    public String choicePriceRange(Model model) {
        model.addAttribute("logged", this.sessionObject.isLogged());
        model.addAttribute("role",
                this.sessionObject.getUser() != null ? this.sessionObject.getUser().getRole() : null);
        return "pricerange";
    }

    @RequestMapping(value = "/orderaccepted", method = RequestMethod.GET)
    public String orderAccepted(Model model) {
        model.addAttribute("logged", this.sessionObject.isLogged());
        model.addAttribute("role",
                this.sessionObject.getUser() != null ? this.sessionObject.getUser().getRole() : null);
        return "acceptedorder";
    }

    @RequestMapping(value = "/execution", method = RequestMethod.GET)
    public String orderExecution(Model model){
        model.addAttribute("logged", this.sessionObject.isLogged());
        model.addAttribute("role",
                this.sessionObject.getUser() != null ? this.sessionObject.getUser().getRole() : null);
        return "executionorder";
    }
}
