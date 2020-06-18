package com.personal.web.spring.web.spring.api;

import com.personal.web.spring.web.spring.models.Item;
import com.personal.web.spring.web.spring.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public int addItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }

    @GetMapping
    public Item viewItem(@RequestParam String id) {
        return itemService.viewItem(id);
    }

}
