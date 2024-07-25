package com.example.store.controller;

import com.example.store.dto.InstrumentsDTO;
import com.example.store.entity.Instruments;
import com.example.store.service.InstrumentsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/instrument")
@Tag(name = "Controller for work with instruments", description = "API для управления инструментами")
@RestController
@AllArgsConstructor
public class InstrumentsController {
    private final InstrumentsService instrumentsService;

    @PostMapping
    @Operation(summary = "Добавление инструмента", description = "Добавление нового инструмента в бд")
    public ResponseEntity<Instruments> create(@RequestBody InstrumentsDTO dto) {
        return new ResponseEntity<>(instrumentsService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    @Operation(summary = "получения списка инструментов", description = "Получение списка всех инструментов в бд")
    public ResponseEntity<List<Instruments>> getAll(){
        return new ResponseEntity<>(instrumentsService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "получения инструмента по id", description = "Получение информации об инструменте по id")
    public ResponseEntity<Instruments> getById(@PathVariable("id") Long id) {
        if(instrumentsService.getById(id)==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(instrumentsService.getById(id),HttpStatus.OK);
    }
    @GetMapping("/higher/{price}")
    @Operation(summary = "получения инструментов дороже чем число", description = "Получение информации об инструменте дороже указанной цены")
    public ResponseEntity<List<Instruments>> getInstrumentsAbovePrice(@PathVariable("price") Long price) {
        if(instrumentsService.getInstrumentsAbovePrice(price)==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(instrumentsService.getInstrumentsAbovePrice(price),HttpStatus.OK);
    }
    @GetMapping(value="/lower/{price}")
    @Operation(summary = "получения инструментов дешевле чем число", description = "Получение информации об инструментах дешевле указанной цены")
    public ResponseEntity<List<Instruments>> findByPriceLessThen(@PathVariable("price") Long price) {
        if(instrumentsService.getInstrumentsBelowPrice(price)==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(instrumentsService.getInstrumentsBelowPrice(price),HttpStatus.OK);
    }
    @PutMapping
    @Operation(summary = "Изменение инструмента", description = "Изменение существующего инструмента по id")
    public ResponseEntity<Instruments> update(@RequestBody Instruments instrument) {
        return new ResponseEntity<>(instrumentsService.update(instrument),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление инструмента", description = "удаление инструмента по id")
    public HttpStatus delete(@PathVariable Long id) {
        instrumentsService.delete(id);
        return HttpStatus.OK;
    }
}
