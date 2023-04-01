package com.rruslek.sneakershopa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {
    @GetMapping("/cart")
    String getCart(Model model) {
        model.addAttribute("title", "Your Cart");
        return "cart";
    }
}
