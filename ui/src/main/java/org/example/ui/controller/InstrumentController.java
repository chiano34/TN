package org.example.ui.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.ui.client.InstrumentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Controller for work with client query", description = "API для поиска необходимых инструментов")
public class InstrumentController {

    @Autowired
    private InstrumentClient instrumentClient;
    @GetMapping(value="/all-instruments")
    @Operation(summary = "Поиск всех инструментов", description = "Список всех инструментов")
    public Object fetchInstrument() {
        return instrumentClient.getInstrument();
    }
    @GetMapping(value="/higher-instruments/{price}")
    @Operation(summary = "Поиск всех инструментов дороже чем указанная цена",
            description = "Список всех инструментов по цене выше заданной")
    public Object higherInstrument(@PathVariable Long price) {
        return instrumentClient.getHigher(price);
    }
    @GetMapping("/lower-instruments/{price}")
    @Operation(summary = "Поиск всех инструментов дешевле чем указанная цена",
            description = "Список всех инструментов по цене ниже заданной")
    public Object lowerInstrument(@PathVariable Long price) {
        return instrumentClient.getLower(price);
    }
}