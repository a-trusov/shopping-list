package com.example.shoppinglist.controller;

import com.example.shoppinglist.model.ShoppingItem;
import com.example.shoppinglist.model.ShoppingItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShoppingListController {

    private final ShoppingItemRepository repository;

    public ShoppingListController(ShoppingItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String indexPage(Model model) {
        model.addAttribute("items", repository.findAll());
        model.addAttribute("item", new ShoppingItem());
        return "index";
    }

    @PostMapping
    public String newShoppingItem(ShoppingItem item) {
        repository.save(item);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteShoppingItem(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return "redirect:/";
    }
}
