package com.web.expensetracker.controller;

import com.web.expensetracker.model.Category;
import com.web.expensetracker.model.Currency;
import com.web.expensetracker.model.PaymentMethod;
import com.web.expensetracker.model.Tag;
import com.web.expensetracker.service.MasterDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/master")
public class MasterDataController {

    @Autowired
    private MasterDataService masterDataService;

    // -------- Category APIs --------

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return masterDataService.getAllCategories();
    }

    @PostMapping("/categories")
    public Category createCategory(@RequestBody Category category) {
        return masterDataService.createCategory(category);
    }

    @PutMapping("/categories/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category category) {
        return masterDataService.updateCategory(id, category);
    }

    @DeleteMapping("/categories/{id}")
    public void deleteCategory(@PathVariable Long id) {
        masterDataService.deleteCategory(id);
    }

    // -------- Currency APIs --------

    @GetMapping("/currencies")
    public List<Currency> getAllCurrencies() {
        return masterDataService.getAllCurrencies();
    }

    @PostMapping("/currencies")
    public Currency createCurrency(@RequestBody Currency currency) {
        return masterDataService.createCurrency(currency);
    }

    @PutMapping("/currencies/{id}")
    public Currency updateCurrency(@PathVariable Long id, @RequestBody Currency currency) {
        return masterDataService.updateCurrency(id, currency);
    }

    @DeleteMapping("/currencies/{id}")
    public void deleteCurrency(@PathVariable Long id) {
        masterDataService.deleteCurrency(id);
    }

    // -------- Tag APIs --------

    @GetMapping("/tags")
    public List<Tag> getAllTags() {
        return masterDataService.getAllTags();
    }

    @PostMapping("/tags")
    public Tag createTag(@RequestBody Tag tag) {
        return masterDataService.createTag(tag);
    }

    @PutMapping("/tags/{id}")
    public Tag updateTag(@PathVariable Long id, @RequestBody Tag tag) {
        return masterDataService.updateTag(id, tag);
    }

    @DeleteMapping("/tags/{id}")
    public void deleteTag(@PathVariable Long id) {
        masterDataService.deleteTag(id);
    }

    // Java
// -------- Payment Method APIs --------

    @GetMapping("/payment-methods")
    public List<PaymentMethod> getAllPaymentMethods() {
        return masterDataService.getAllPaymentMethods();
    }

    @PostMapping("/payment-methods")
    public PaymentMethod createPaymentMethod(@RequestBody PaymentMethod paymentMethod) {
        return masterDataService.createPaymentMethod(paymentMethod);
    }

    @PutMapping("/payment-methods/{id}")
    public PaymentMethod updatePaymentMethod(@PathVariable Long id, @RequestBody PaymentMethod paymentMethod) {
        return masterDataService.updatePaymentMethod(id, paymentMethod);
    }

    @DeleteMapping("/payment-methods/{id}")
    public void deletePaymentMethod(@PathVariable Long id) {
        masterDataService.deletePaymentMethod(id);
    }
}
