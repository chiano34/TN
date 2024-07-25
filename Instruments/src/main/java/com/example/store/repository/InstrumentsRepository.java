package com.example.store.repository;

import com.example.store.entity.Instruments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface InstrumentsRepository extends JpaRepository<Instruments, Long> {
    List<Instruments> findByPriceGreaterThan(double price);
    List<Instruments> findByPriceLessThan(double price);
}
