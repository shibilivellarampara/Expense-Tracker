package com.web.expensetracker.service;

import com.web.expensetracker.model.*;
import com.web.expensetracker.repository.*;
import com.web.expensetracker.security.LoggedInUserProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository repo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private CurrencyRepository currencyRepo;

    @Autowired
    private PaymentMethodRepository paymentMethodRepo;

    @Autowired
    private LoggedInUserProvider loggedInUserProvider;

    @Autowired
    private CategoryRepository categoryRepo;

    @Autowired
    private TagRepository tagRepo;

    public List<Expense> getAll() {
        return repo.findAll();
    }

    public Expense saveExpense(Expense expense) {
        if (expense.getId() == null) {
            expense.setCreatedAt(LocalDateTime.now());
        }
        expense.setUpdatedAt(LocalDateTime.now());

        List<Tag> tagEntities = new ArrayList<>();
        for (Tag tag : expense.getTags()) {
            Tag existing = tagRepo.findByName(tag.getName())
                    .orElseThrow(() -> new RuntimeException("Tag not found: " + tag.getName()));
            tagEntities.add(existing);
        }
        expense.setTags(tagEntities);

        User user = userRepo.findByUsername(loggedInUserProvider.getUsername())
                .orElseThrow(() -> new NoSuchElementException("User not found: " + loggedInUserProvider.getUsername()));

        Category category = categoryRepo.findByName(expense.getCategory().getName())
                .orElseThrow(() -> new NoSuchElementException("Category not found: " + expense.getCategory().getName()));

        Currency currency = currencyRepo.findByCode(expense.getCurrency().getCode())
                .orElseThrow(() -> new NoSuchElementException("Currency not found: " + expense.getCurrency().getCode()));

        PaymentMethod method = paymentMethodRepo.findByType(expense.getPaymentMethod().getType())
                .orElseThrow(() -> new NoSuchElementException("Payment method not found: " + expense.getPaymentMethod().getType()));

        expense.setUser(user);
        expense.setCategory(category);
        expense.setCurrency(currency);
        expense.setPaymentMethod(method);

        return repo.save(expense);
    }


    public Expense updateExpense(Expense expense) {
        if (expense.getId() == null) {
            throw new IllegalArgumentException("Expense ID must not be null for update");
        }
        expense.setUpdatedAt(LocalDateTime.now());
        return repo.save(expense);
    }

    public void deleteExpense(Long id) {
        repo.deleteById(id);
    }

    public Expense getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Expense> getByDateRange(LocalDate start, LocalDate end) {
        return repo.findByDateBetween(start, end);
    }

    public List<Expense> getByCategory(Category category) {
        return repo.findByCategory(category);
    }

    public List<Expense> getByTitle(String title) {
        return repo.findByTitleContaining(title);
    }

    public List<Expense> getByAmountGreaterThan(double amount) {
        return repo.findByAmountGreaterThan(amount);
    }

    public List<Expense> getByUser(Long userId) {
        return repo.findByUserId(userId);
    }

    public List<Expense> getByStatus(String status) {
        return repo.findByStatus(status);
    }

    public List<Expense> getByCurrency(String currencyCode) {
        Currency currency = currencyRepo.findByCode(currencyCode)
                .orElseThrow(() -> new RuntimeException("Currency not found"));
        return repo.findByCurrency(currency);
    }

    public List<Expense> getByPaymentMethod(String methodName) {
        PaymentMethod paymentMethod = paymentMethodRepo.findByType(methodName)
                .orElseThrow(() -> new RuntimeException("Payment Method not found"));
        return repo.findByPaymentMethod(paymentMethod);
    }

    public List<Expense> getByTags(String tag) {
        return repo.findByTagsNameContaining(tag); // assuming custom query
    }

    public List<Expense> getByLocation(String location) {
        return repo.findByLocationContaining(location);
    }

    public List<Expense> getByNotes(String notes) {
        return repo.findByNotesContaining(notes);
    }

    public List<Expense> getByReceiptUrl(String receiptUrl) {
        return repo.findByReceiptUrlContaining(receiptUrl);
    }

    public List<Expense> getByRecurringFrequency(String recurringFrequency) {
        return repo.findByRecurringFrequency(recurringFrequency);
    }

    public List<Expense> getByCreatedAt(LocalDateTime createdAt) {
        LocalDate date = createdAt.toLocalDate();
        return repo.findByCreatedAtBetween(date.atStartOfDay(), date.plusDays(1).atStartOfDay());
    }

    public List<Expense> getByUpdatedAt(LocalDateTime updatedAt) {
        LocalDate date = updatedAt.toLocalDate();
        return repo.findByUpdatedAtBetween(date.atStartOfDay(), date.plusDays(1).atStartOfDay());
    }

    public List<Expense> getByRecurringEndDate(LocalDate recurringEndDate) {
        return repo.findByRecurringEndDate(recurringEndDate);
    }
}
