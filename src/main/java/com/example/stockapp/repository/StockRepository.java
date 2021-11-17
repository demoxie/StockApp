package com.example.stockapp.repository;

import com.example.stockapp.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock,Long> {
    List<Stock> findAll();
    Optional<Stock> findById(Long id);
    Stock deleteStocksById(Long stockId);


}
