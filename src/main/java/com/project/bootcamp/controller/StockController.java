package com.project.bootcamp.controller;

import com.project.bootcamp.model.dto.StockDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/stocks")
public class StockController {


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO stockDTO) {
        return ResponseEntity.ok(stockDTO);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> update(@Valid @RequestBody StockDTO stockDTO) {
        return ResponseEntity.ok(stockDTO);
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findAll() {
        List<StockDTO> list = new ArrayList<>();
        StockDTO dto = new StockDTO(1L, "Magazine", 100.0, LocalDate.now(), 10.0);
        list.add(dto);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockDTO> findById(@PathVariable("id") Long id) {
        List<StockDTO> list = new ArrayList<>();
        StockDTO dto1 = new StockDTO(1L, "Magazine", 100.0, LocalDate.now(), 10.0);
        StockDTO dto2 = new StockDTO(2L, "Nubank", 150.0, LocalDate.now(), 15.0);
        list.add(dto1);
        list.add(dto2);
        StockDTO selection =  list.stream().filter(x -> x.getId().compareTo(id) == 0)
                .findFirst().get();
        return ResponseEntity.ok(selection);
    }

}