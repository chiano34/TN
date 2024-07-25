package org.example.ui.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import io.swagger.v3.oas.annotations.Operation;

@FeignClient(name = "instrumentClient", url = "http://localhost:8082")
public interface InstrumentClient {

    @GetMapping(value="/instrument")

    String getInstrument();
    @GetMapping(value="/instrument/lower/{price}")
    String getLower(@PathVariable("price") Long price);
    @GetMapping(value="/instrument/higher/{price}")
    String getHigher(@PathVariable("price") Long price);

}