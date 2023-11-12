package tn.esprit.devops_project.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.entities.dtos.StockDTO;
import tn.esprit.devops_project.services.iservices.IStockService;
import java.util.List;
import org.modelmapper.ModelMapper;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class StockController {

    IStockService stockService;
    private final ModelMapper modelMapper=new ModelMapper();

    @PostMapping("/stock")
    Stock addStock(@RequestBody StockDTO stockDTO){
        Stock stock=this.modelMapper.map(stockDTO, Stock.class);
        return stockService.addStock(stock);
    }

    @GetMapping("/stock/{id}")
    Stock retrieveStock(@PathVariable Long id){
        return stockService.retrieveStock(id);
    }

    @GetMapping("/stock")
    List<Stock> retrieveAllStock(){
        return stockService.retrieveAllStock();
    }


}
