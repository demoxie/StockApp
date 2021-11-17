package com.example.stockapp.services;

import com.example.stockapp.model.Stock;

import java.util.List;

public interface StockService {
    List<Stock> getAllStocks();
    Stock getAStock(Long stockId);
    Stock updateStock(Stock stock,Long stockId);
    Stock deleteStock(Long stockId);
    Stock createStock(Stock stock);

}
