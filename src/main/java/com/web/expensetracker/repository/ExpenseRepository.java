package com.web.expensetracker.repository;

import com.web.expensetracker.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
        List<Expense> findByCategory(Category category);
        List<Expense> findByUserId(long userId);

        List<Expense> findByStatus(String status);
        List<Expense> findByCreatedAtBetween(LocalDate startDate, LocalDate endDate);
        List<Expense> findByUpdatedAtBetween(LocalDate startDate, LocalDate endDate);
        List<Expense> findByDeletedAtBetween(LocalDate startDate, LocalDate endDate);
        List<Expense> findByImageUrlContaining(String imageUrl);
        List<Expense> findByCurrency(Currency currency);
       // ✅ CORRECT
        List<Expense> findByPaymentMethod(PaymentMethod paymentMethod);

        List<Expense> findByTagsContaining(Tag tags);
        List<Expense> findByLocationContaining(String location);
        List<Expense> findByNotesContaining(String notes);
        List<Expense> findByReceiptUrlContaining(String receiptUrl);
        List<Expense> findByRecurringFrequency(String recurringFrequency);

        List<Expense> findByRecurringEndDate(LocalDate recurringEndDate);
        List<Expense> findByRecurringEndDateBetween(LocalDate startDate, LocalDate endDate);
        List<Expense> findByRecurringEndDateAfter(LocalDate date);
        List<Expense> findByRecurringEndDateBefore(LocalDate date);
        List<Expense> findByRecurringEndDateIsNull();


   List<Expense> findByDateBetween(LocalDate startDate, LocalDate endDate);
     List<Expense> findByTitleContaining(String title);
 List<Expense> findByAmountGreaterThan(double amount);

        List<Expense> findByTagsNameContaining(String tag);

        List<Expense> findByUpdatedAtBetween(LocalDateTime localDateTime, LocalDateTime localDateTime1);

        List<Expense> findByCreatedAtBetween(LocalDateTime localDateTime, LocalDateTime localDateTime1);
}
