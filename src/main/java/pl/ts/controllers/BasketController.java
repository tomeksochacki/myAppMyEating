package pl.ts.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BasketController {

    //TODO dodać tu mapingi
    @RequestMapping(value = "/basket", method = RequestMethod.GET)
    public String addOrderToBasket(){
        
    }


}
