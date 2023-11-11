package tn.esprit.devops_project;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.StockRepository;
import tn.esprit.devops_project.services.StockServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StockMockitoTest {

    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private StockServiceImpl stockService;

    @Test
    void testAddStock() {
        // Given
        Stock stockToAdd = new Stock(/* Add relevant details */);
        when(stockRepository.save(any(Stock.class))).thenReturn(stockToAdd);

        // When
        Stock addedStock = stockService.addStock(stockToAdd);

        // Then
        assertEquals(stockToAdd, addedStock);
        verify(stockRepository, times(1)).save(any(Stock.class));
    }

    @Test
    void testRetrieveStock() {
        // Given
        Long stockId = 1L;
        Stock expectedStock = new Stock(/* Add relevant details */);
        when(stockRepository.findById(stockId)).thenReturn(Optional.of(expectedStock));

        // When
        Stock retrievedStock = stockService.retrieveStock(stockId);

        // Then
        assertEquals(expectedStock, retrievedStock);
        verify(stockRepository, times(1)).findById(stockId);
    }

    @Test
    void testRetrieveAllStock() {
        // Given
        List<Stock> stockList = new ArrayList<>();
        stockList.add(new Stock(/* Add relevant details */));
        when(stockRepository.findAll()).thenReturn(stockList);

        // When
        List<Stock> retrievedStockList = stockService.retrieveAllStock();

        // Then
        assertEquals(stockList, retrievedStockList);
        verify(stockRepository, times(1)).findAll();
    }
}
