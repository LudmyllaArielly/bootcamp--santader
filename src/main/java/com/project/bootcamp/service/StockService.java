package com.project.bootcamp.service;

import com.project.bootcamp.mapper.StockMapper;
import com.project.bootcamp.model.dto.StockDTO;
import com.project.bootcamp.model.entities.Stock;
import com.project.bootcamp.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private StockMapper stockMapper;

    @Transactional
    public StockDTO save(StockDTO stockDTO) {
       Stock stock = stockMapper.toEntity(stockDTO);
       stockRepository.save(stock);
       return stockMapper.toDto(stock);
    }
}
