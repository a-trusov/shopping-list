package com.example.shoppinglist.controller;

import com.example.shoppinglist.service.UserRepresentation;
import com.example.shoppinglist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    // отображает форму
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }


    // отображает форму
    @GetMapping("/register")
    public String registerPage(Model model) {

        model.addAttribute("user", new UserRepresentation());
        return "register";
    }

    //обрабатывает данные с формы
    @PostMapping("/register")
    public String registerNewUser(@Valid @ModelAttribute("user") UserRepresentation representation,
                                  BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "register";
        }

        if (!representation.getPassword().equals((representation.getRepeatPassword()))) {
            bindingResult.rejectValue("password", "", "Пароли не совпадают");
            return "register";
        }

        userService.create(representation);

        return "redirect:/login";
    }

}
