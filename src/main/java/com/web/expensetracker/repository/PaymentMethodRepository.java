package com.web.expensetracker.repository;

import com.web.expensetracker.model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {

    // Find a payment method by its name
    // Example: "Cash", "Credit Card"

    Optional<PaymentMethod> findByType(String name); // Example: "Cash", "Credit Card"
}
