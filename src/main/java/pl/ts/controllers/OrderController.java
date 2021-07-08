package pl.ts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.ts.database.Database;
import pl.ts.model.Dish;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    Database database;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String addOrder(Model model){
        List<Dish> dishes = this.database.getDishes();
        model.addAttribute("dishes", dishes);
        return "addorder";
    }

    @RequestMapping(value = "/pricerange", method = RequestMethod.GET)
    public String choicePriceRange(){
        return "pricerange";
    }

    @RequestMapping(value = "/orderaccepted", method = RequestMethod.GET)
    public String orderAccepted(){
        return "acceptedorder";
    }
}
