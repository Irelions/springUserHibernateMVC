package hibernate.controller;

import hibernate.model.User;
import hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showAllUsers(Model model){
        List<User> allUsers = userService.listUsers();
        model.addAttribute("allUsers", allUsers);
        return "index";
    }
    @GetMapping("/show")
    public String show(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.showUser(id));
        return "show";
    }
    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/";
    }

    @PatchMapping("/edit/{id}")
    public String update(@PathVariable("id") int id, Model model) {
        User user = userService.showUser(id);
        model.addAttribute("user", user);
        return "new";
    }
}
