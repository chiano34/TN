package com.example.store.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name="instruments")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Instruments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String vendorCode;
    private String type;
    private String name;
    private Long price;
    private String description;
}
