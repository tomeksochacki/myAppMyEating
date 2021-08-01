package pl.ts.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.ts.database.Database;
import pl.ts.model.Address;
import pl.ts.model.Dish;
import pl.ts.model.Order;
import pl.ts.model.User;
import pl.ts.session.SessionObject;
import pl.ts.validators.LoginValidator;
import pl.ts.validators.OrderValidator;

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

    @RequestMapping(value = "/dataorder", method = RequestMethod.GET)
    public String addDataOrderForm(Model model) {
        model.addAttribute("adres", new Address());
        model.addAttribute("user", new User());
        model.addAttribute("info", this.sessionObject.getInfo());
        return "adddataorder";
    }

    /*@RequestMapping(value = "/dataorder", method = RequestMethod.POST)
    public String addDataOrder(@ModelAttribute User user, @ModelAttribute Address address) {
        if (!OrderValidator.validate(user, address)){
            this.sessionObject.setInfo("Nieprawidłowe dane w formularzu!!");
            return "redirect:/dataorder";
        }
        this.database.addOrder(user, address);
        return "acceptedorder";
    }*/

    @RequestMapping(value = "/pricerange/{taste}", method = RequestMethod.GET)
    public String choicePriceRange(Model model, @PathVariable String taste) {
        model.addAttribute("logged", this.sessionObject.isLogged());
        model.addAttribute("role",
                this.sessionObject.getUser() != null ? this.sessionObject.getUser().getRole() : null);
        //database.addOrder();

        System.out.println(taste);
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
    public String orderExecution(Model model) {
        //TODO dodać listę orderów i w bazie danych dodać taką listę + dodać taki obiekt jak zamówienie
        model.addAttribute("logged", this.sessionObject.isLogged());
        model.addAttribute("role",
                this.sessionObject.getUser() != null ? this.sessionObject.getUser().getRole() : null);
        return "executionorder";
    }

   /* //TODO jak stworzyć obiekt Order w tej metodzie poniżej
    @RequestMapping(value = "/ordersformanufacturers", method = RequestMethod.GET)
    public String order(){
        Order order = new Order(this.sessionObject.getUser(),  )
        this.database.addOrder(order);

    }*/
}
