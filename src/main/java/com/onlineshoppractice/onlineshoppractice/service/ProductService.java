package com.onlineshoppractice.onlineshoppractice.service;

import com.onlineshoppractice.onlineshoppractice.dto.ProductDTO;
import com.onlineshoppractice.onlineshoppractice.model.Cart;
import com.onlineshoppractice.onlineshoppractice.model.Inventory;
import com.onlineshoppractice.onlineshoppractice.model.Product;
import com.onlineshoppractice.onlineshoppractice.repository.CartRepository;
import com.onlineshoppractice.onlineshoppractice.repository.ProductRepository;
import com.onlineshoppractice.onlineshoppractice.service.serviceinterface.ProductServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductServiceInterface {

    private final ProductRepository productRepository;
    private final InventoryService inventoryService;
    private final CartRepository cartRepository;

    public void createProduct(Product newProduct) {
        productRepository.save(newProduct);
        inventoryService.addProductToInventory(newProduct);
    }

    public void addProduct(Product addProduct) {
        Optional<Product> findProduct = productRepository.findByProductName(addProduct.getProductName());
        if (findProduct.isPresent()) {
            Product product = findProduct.get();
            product.setProductAmount(product.getProductAmount() + 1);
            productRepository.save(product);
        } else {
            productRepository.save(addProduct);
        }
    }

    public List<ProductDTO> getAllProductDTO() {
        return productRepository.findAll()
                .stream()
                .map(ProductService::convertToProductDTO)
                .collect(Collectors.toList());
    }

    public void updateProduct(Long productId, Product updateProduct) {
        Product product = findProductById(productId);
        if (product != null) {
            product.setProductName(updateProduct.getProductName());
            product.setProductPrice(updateProduct.getProductPrice());
            product.setProductType(updateProduct.getProductType());
            product.setProductDescription(updateProduct.getProductDescription());
            product.setProductAmount(updateProduct.getProductAmount());
            setInventoryProductAndFindById(product);
            setAllCartForProductAndFindById(product);
            productRepository.save(product);
        }
    }

    public void removeProduct(Long productId) {
        Product product = findProductById(productId);
        if (product != null) {
            List<Product> cartProduct = product.getCart().getListOfProduct();
            cartProduct.remove(product);
            product.getCart().setListOfProduct(cartProduct);
            List<Product> onlineShopProducts = product.getInventory().getOnlineShopProducts();
            onlineShopProducts.remove(product);
            product.getInventory().setOnlineShopProducts(onlineShopProducts);
            productRepository.delete(product);
        }
    }

    public Product findProductById(Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        return product.orElse(null);
    }

    protected static ProductDTO convertToProductDTO(Product product) {
        ProductDTO newProductDTO = new ProductDTO();

        newProductDTO.setProductName(product.getProductName());
        newProductDTO.setProductPrice(product.getProductPrice());
        newProductDTO.setProductType(product.getProductType());
        newProductDTO.setProductDescription(product.getProductDescription());
        newProductDTO.setProductAmount(product.getProductAmount());
        newProductDTO.setProductAvailability(product.getProductAvailability());

        return newProductDTO;
    }

    private void setInventoryProductAndFindById(Product updateProduct) {
        Inventory inventory = updateProduct.getInventory();
        Optional<Product> inventoryProduct = inventory.getOnlineShopProducts().stream()
                .filter(findProduct -> findProduct.getId().equals(updateProduct.getId()))
                .findFirst();

        if (inventoryProduct.isPresent()) {
            List<Product> onlineShopProducts = inventory.getOnlineShopProducts();
            int indexOfInventoryProduct = onlineShopProducts.indexOf(inventoryProduct.get());
            onlineShopProducts.set(indexOfInventoryProduct, updateProduct);
            inventory.setOnlineShopProducts(onlineShopProducts);
        }
    }

    private void setAllCartForProductAndFindById(Product updateProduct) {
        for (Cart cart: cartRepository.findAll()) {
            Optional<Product> cartProduct = cart.getListOfProduct().stream()
                    .filter(findCartProduct -> findCartProduct.getId().equals(updateProduct.getId()))
                    .findFirst();

            if (cartProduct.isPresent()) {
                List<Product> listOfProduct = cart.getListOfProduct();
                int indexOfCartProduct = listOfProduct.indexOf(cartProduct.get());
                listOfProduct.set(indexOfCartProduct, updateProduct);
                cart.setListOfProduct(listOfProduct);
            }
        }
    }
}
