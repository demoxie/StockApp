package com.example.stockapp.contoller;

import com.example.stockapp.model.Stock;
import com.example.stockapp.repository.StockRepository;
import com.example.stockapp.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="api/stocks/")
public class StockController {

    private StockService stockService;
    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }
    @PostMapping("createnewstock/")
    public ResponseEntity<?> createStocks(@RequestBody Stock stock){
        Stock newStock = stockService.createStock(stock);
        return newStock == null ? new ResponseEntity<>(null, HttpStatus.FORBIDDEN) : new ResponseEntity<>(newStock,HttpStatus.CREATED);
    }
    @GetMapping("allstocks/")
    public ResponseEntity<?> getAllStocks(){
        List<Stock> stocks = stockService.getAllStocks();
        return stocks == null ? new ResponseEntity<>(null, HttpStatus.NOT_FOUND) : new ResponseEntity<>(stocks,HttpStatus.OK);
    }
    @GetMapping("stock/")
    public ResponseEntity<?> getStock(@PathVariable Long stockId){
        Stock stock = stockService.getAStock(stockId);
        return stock == null ? new ResponseEntity<>(null, HttpStatus.NOT_FOUND) : new ResponseEntity<>(stock,HttpStatus.OK);
    }
    @PutMapping("updatestock/{stockId}")
    public ResponseEntity<?> updateStock(@RequestBody Stock stocks,@PathVariable Long stockId){
        Stock stock = stockService.updateStock(stocks,stockId);
        return stock == null ? new ResponseEntity<>(null, HttpStatus.NOT_FOUND) : new ResponseEntity<>(stock,HttpStatus.OK);
    }
    @DeleteMapping("deletestock/{stockId}")
    public ResponseEntity<?> deleteStock(@PathVariable Long stockId){
        Stock stock = stockService.deleteStock(stockId);
        return stock == null ? new ResponseEntity<>(null, HttpStatus.NOT_FOUND) : new ResponseEntity<>(stock,HttpStatus.OK);
    }
}
