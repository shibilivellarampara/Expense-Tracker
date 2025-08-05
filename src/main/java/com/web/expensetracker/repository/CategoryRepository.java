package com.web.expensetracker.repository;

import com.web.expensetracker.model.Category;
import com.web.expensetracker.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name); // Example: "INR", "USD"
}
