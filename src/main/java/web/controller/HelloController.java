package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    String title = "Spring-MVC-CRUD Application";

    @GetMapping("/")
    public String printWelcome(ModelMap model) {
        model.addAttribute("title", title);
        return "hello/index";
    }
}
