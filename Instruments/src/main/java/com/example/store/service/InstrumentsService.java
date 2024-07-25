package com.example.store.service;

import com.example.store.dto.InstrumentsDTO;
import com.example.store.entity.Instruments;
import com.example.store.repository.InstrumentsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InstrumentsService {
    private final InstrumentsRepository instrumentsRepository;

    public Instruments create(InstrumentsDTO dto) {
        return instrumentsRepository.save(Instruments.builder()
                .vendorCode(dto.getVendorCode())
                .type(dto.getType())
                .name(dto.getName())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .build());
    }
    public List<Instruments> getAll() {
        return instrumentsRepository.findAll();
    }

    public Instruments getById(Long id) {
        return instrumentsRepository.findById(id).orElse(null);
    }

    public Instruments update(Instruments instrument) {
        return instrumentsRepository.save(instrument);
    }

    public void delete(Long id) {
        instrumentsRepository.deleteById(id);
    }

    public List<Instruments> getInstrumentsAbovePrice(double price) {
        return instrumentsRepository.findByPriceGreaterThan(price);
    }
    public List<Instruments> getInstrumentsBelowPrice(double price) {
        return instrumentsRepository.findByPriceLessThan(price);
    }
}
