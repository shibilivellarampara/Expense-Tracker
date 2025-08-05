package com.web.expensetracker.controller;

import com.web.expensetracker.model.Expense;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.web.expensetracker.service.ExpenseService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService service;

    @GetMapping
    public List<Expense> getAll() {
        return service.getAll();
    }

    @PostMapping("/create")
    public Expense create(@RequestBody Expense expense) {
        System.out.println("Creating expense: " + expense);
        return service.saveExpense(expense)
                ;
    }
    @PutMapping("/update")
    public Expense update(@RequestBody Expense expense) {

        System.out.println("Updating expense: " + expense);
        return service.updateExpense(expense);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteExpense(id);
    }

    @GetMapping("/range")
    public List<Expense> getByRange(@RequestParam String start, @RequestParam String end) {
        return service.getByDateRange(LocalDate.parse(start), LocalDate.parse(end));
    }

}

