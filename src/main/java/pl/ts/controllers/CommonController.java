package pl.ts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.ts.database.Database;
import pl.ts.model.Dish;
import pl.ts.model.view.Mail;

import java.util.List;

@Controller
public class CommonController {

    @Autowired
    Database database;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(Model model){
        return "main";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main2(Model model){
        return "redirect:/";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact(Model model){
        model.addAttribute("mail", new Mail());
        return "contact";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public String processForm(@ModelAttribute Mail mail){
        System.out.println(mail.getName());
        System.out.println(mail.getMessage());
        System.out.println(mail.getTitle());
        return "contact";
    }
}



