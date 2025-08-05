package com.web.expensetracker.repository;

import com.web.expensetracker.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    Optional<Currency> findByCode(String code); // Example: "INR", "USD"
}
