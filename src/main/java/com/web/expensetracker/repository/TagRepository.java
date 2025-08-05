package com.web.expensetracker.repository;

import com.web.expensetracker.model.Currency;
import com.web.expensetracker.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {
    Optional<Tag> findByName(String code);
}
