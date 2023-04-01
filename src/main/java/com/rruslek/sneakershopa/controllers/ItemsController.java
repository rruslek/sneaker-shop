package com.rruslek.sneakershopa.controllers;

import com.rruslek.sneakershopa.models.Item;
import com.rruslek.sneakershopa.repo.ItemRepository;
import com.rruslek.sneakershopa.vars.SneakerTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.rruslek.sneakershopa.vars.SneakerTypes.*;

@Controller
public class ItemsController {
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/")
    String getItems(@RequestParam(value = "type", defaultValue = "ALL") SneakerTypes type, @RequestParam(value = "sortDir", defaultValue = "asc") String sortDir, Model model) {
        Iterable<Item> items;
        if (type == ALL) {
            if (sortDir.equals("desc")) {
                items = itemRepository.findAllByOrderByPriceDesc();
            } else {
                items = itemRepository.findAllByOrderByPrice();
            }
        }
        else {
            if (sortDir.equals("desc")) {
                items = itemRepository.findAllByTypeOrderByPriceDesc(type);
            } else {
                items = itemRepository.findAllByTypeOrderByPrice(type);
            }
        }
        model.addAttribute("items", items);
        model.addAttribute("title", "SneakerShop");

        return "index";
    }

}
