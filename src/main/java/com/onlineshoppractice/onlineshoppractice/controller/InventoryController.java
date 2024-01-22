package com.onlineshoppractice.onlineshoppractice.controller;

import com.onlineshoppractice.onlineshoppractice.dto.InventoryDTO;
import com.onlineshoppractice.onlineshoppractice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/getInventory")
    @ResponseBody
    public InventoryDTO getInventory() {
        return inventoryService.getInventoryDTO();
    }
}
