package com.example.stockapp.services;

import com.example.stockapp.model.Stock;
import com.example.stockapp.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class StockServiceImpl implements StockService{
    @Autowired
    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    private final StockRepository stockRepository;

    @Override
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Stock getAStock(Long stockId) {
        return stockRepository.findById(stockId).orElse(null);
    }

    @Override
    public Stock updateStock(Stock stock,Long stockId) {
        Stock stockToUpdate = stockRepository.findById(stockId).orElse(null);

        assert stockToUpdate != null;
        stockToUpdate.setCurrent_price(stock.getCurrent_price());
        stockToUpdate.setName(stock.getName());
        stockToUpdate.setLast_update(new Timestamp(System.currentTimeMillis()));
        stockRepository.save(stockToUpdate);
        return stockToUpdate;
    }

    @Override
    public Stock deleteStock(Long stockId) {
        Stock stock = stockRepository.findById(stockId).orElse(null);

        if (stock != null) {
            stockRepository.delete(stock);
        }
        return stock;
    }

    @Override
    public Stock createStock(Stock stock) {
        return stockRepository.save(stock);
    }
}
