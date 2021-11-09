package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showUsers(ModelMap model) {
        model.addAttribute("users", userService.findAll());
        return "user/userList";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("user", userService.getById(id));
        return "user/userByID";
    }

    @GetMapping("/create")
    public String showAddUser(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user/addUser";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("user")  User user) {
        userService.create(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, ModelMap model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "user/editUser";
    }

    @PatchMapping("/{id}/edit")
    public String update(@ModelAttribute("user")  User user) {
        userService.update(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

}
