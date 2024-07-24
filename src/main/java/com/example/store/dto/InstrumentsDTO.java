package com.example.store.dto;

import lombok.Data;

@Data
public class InstrumentsDTO {
    private String vendorCode;
    private String type;
    private String name;
    private Long price;
    private String description;
}
