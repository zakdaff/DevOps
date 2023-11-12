package tn.esprit.devops_project;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.ProductRepository;
import tn.esprit.devops_project.repositories.StockRepository;
import tn.esprit.devops_project.services.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class ProductMockTest {
    @Mock
    private ProductRepository productRepository;

    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void testAddProduct() {
        // Arrange
        Long stockId = 1L;
        Stock stock = new Stock();
        Product product = new Product();

        when(stockRepository.findById(stockId)).thenReturn(Optional.of(stock));
        when(productRepository.save(any())).thenReturn(product);

        // Act
        Product result = productService.addProduct(product, stockId);

        // Assert
        assertEquals(product, result);
        verify(stockRepository, times(1)).findById(stockId);
        verify(productRepository, times(1)).save(product);
    }

    @Test
    void testRetrieveProduct() {
        // Arrange
        Long productId = 1L;
        Product product = new Product();

        when(productRepository.findById(productId)).thenReturn(Optional.of(product));

        // Act
        Product result = productService.retrieveProduct(productId);

        // Assert
        assertEquals(product, result);
        verify(productRepository, times(1)).findById(productId);
    }

    @Test
    void testRetreiveAllProduct() {
        // Arrange
        List<Product> productList = new ArrayList<>();
        when(productRepository.findAll()).thenReturn(productList);

        // Act
        List<Product> result = productService.retreiveAllProduct();

        // Assert
        assertEquals(productList, result);
        verify(productRepository, times(1)).findAll();
    }

}
