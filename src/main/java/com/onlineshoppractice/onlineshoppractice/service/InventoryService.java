package com.onlineshoppractice.onlineshoppractice.service;

import com.onlineshoppractice.onlineshoppractice.dto.InventoryDTO;
import com.onlineshoppractice.onlineshoppractice.dto.ProductDTO;
import com.onlineshoppractice.onlineshoppractice.model.Inventory;
import com.onlineshoppractice.onlineshoppractice.model.Product;
import com.onlineshoppractice.onlineshoppractice.repository.InventoryRepository;
import com.onlineshoppractice.onlineshoppractice.service.serviceinterface.InventoryServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService implements InventoryServiceInterface {

    private final InventoryRepository inventoryRepository;

    public InventoryDTO getInventoryDTO() {
        return inventoryRepository.findAll()
                .stream()
                .map(this::convertToInventoryDTO)
                .toList().getFirst();
    }
    public void addProductToInventory(Product newProduct) {
        Inventory inventory = inventoryRepository.findAll().getLast();
        inventory.getOnlineShopProducts().add(newProduct);
        inventory.setOnlineShopProducts(inventory.getOnlineShopProducts());
        inventoryRepository.save(inventory);
    }

    public void removeProductFromInventory(Product removeProduct) {
        Inventory inventory = inventoryRepository.findAll().getLast();
        inventory.getOnlineShopProducts().remove(removeProduct);
        inventory.setOnlineShopProducts(inventory.getOnlineShopProducts());
        inventoryRepository.save(inventory);
    }

    private InventoryDTO convertToInventoryDTO(Inventory inventory) {
        InventoryDTO inventoryDTO = new InventoryDTO();

        //Avoid the real Product object to be exposed from InventoryDTO.
        List<ProductDTO> convertProductsToDTO = inventory.getOnlineShopProducts()
                .stream()
                .map(ProductService::convertToProductDTO)
                .toList();

        inventoryDTO.setOnlineShopProductDTO(convertProductsToDTO);

        return inventoryDTO;
    }

}
