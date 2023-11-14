package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.ProductCategory;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.ProductRepository;
import tn.esprit.devops_project.repositories.StockRepository;

import java.util.List;
import java.util.Optional;

class ProductServiceImplTest {

    @Test
    void testAddProduct() {
        // Create mock dependencies
        ProductRepository productRepository = Mockito.mock(ProductRepository.class);
        StockRepository stockRepository = Mockito.mock(StockRepository.class);

        // Create an instance of ProductServiceImpl and inject the mock dependencies
        ProductServiceImpl productService = new ProductServiceImpl(productRepository, stockRepository);

        // Define the behavior of the mock repositories
        Long stockId = 1L;
        Product product = new Product();
        when(stockRepository.findById(stockId)).thenReturn(Optional.of(new Stock())); // Mock stock lookup
        when(productRepository.save(Mockito.any(Product.class))).thenReturn(product);
        System.out.println("Starting the testAddProduct method...");

        // Call the method to be tested
        Product savedProduct = productService.addProduct(product, stockId);
        System.out.println("Product saved successfully: ");
        System.out.println("Mockito AddProduct passed successfully!");


        // Assertions
        assertNotNull(savedProduct);
        // Add more assertions as needed
    }

    // Similarly, write tests for other methods like retrieveProduct, retrieveAllProduct, etc.
}
