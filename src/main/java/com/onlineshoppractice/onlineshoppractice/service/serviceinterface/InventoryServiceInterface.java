package com.onlineshoppractice.onlineshoppractice.service.serviceinterface;

import com.onlineshoppractice.onlineshoppractice.dto.InventoryDTO;
import com.onlineshoppractice.onlineshoppractice.model.Product;

public interface InventoryServiceInterface {
    InventoryDTO getInventoryDTO();
    void addProductToInventory(Product newProduct);
    void removeProductFromInventory(Product removeProduct);
}
