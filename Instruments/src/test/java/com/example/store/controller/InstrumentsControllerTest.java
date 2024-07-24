package com.example.store.controller;

import com.example.store.entity.Instruments;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InstrumentsControllerTest {
    @Autowired
    TestRestTemplate template;

    @Test
    void getAll() {
        ResponseEntity<Instruments[]> entity = template.getForEntity("/instrument", Instruments[].class);
        assertEquals(HttpStatus.OK,entity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON,entity.getHeaders().getContentType());
        Instruments[] instruments = entity.getBody();
        assertTrue(instruments.length >= 3);
        assertEquals("x-101",instruments[0].getName());
        assertEquals("x-102",instruments[1].getName());
        assertEquals("x-103",instruments[2].getName());
    }
    @Test
    void getById() {
        Instruments instruments = template.getForObject("/instrument/1", Instruments.class);
        assertEquals(1,instruments.getId());
        assertEquals("1001",instruments.getVendorCode());
        assertEquals("guitar",instruments.getType());
        assertEquals("x-101",instruments.getName());
        assertEquals(1000,instruments.getPrice());
        assertEquals("goodguitar",instruments.getDescription());
    }
    @Test
    void notfound404() {
        ResponseEntity<Instruments> entity = template.getForEntity("/instrument/9999", Instruments.class);
        assertEquals(HttpStatus.NOT_FOUND, entity.getStatusCode());
    }
}