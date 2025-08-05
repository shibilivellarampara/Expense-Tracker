package com.web.expensetracker.service;

import com.web.expensetracker.model.Category;
import com.web.expensetracker.model.Currency;
import com.web.expensetracker.model.PaymentMethod;
import com.web.expensetracker.model.Tag;
import com.web.expensetracker.repository.CategoryRepository;
import com.web.expensetracker.repository.CurrencyRepository;
import com.web.expensetracker.repository.PaymentMethodRepository;
import com.web.expensetracker.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasterDataService {

    @Autowired
    private CategoryRepository categoryRepo;

    @Autowired
    private CurrencyRepository currencyRepo;

    @Autowired
    private TagRepository tagRepo;

    @Autowired
    private PaymentMethodRepository paymentMethodRepo;

    // --- Category ---

    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    public Category createCategory(Category category) {
        return categoryRepo.save(category);
    }

    public Category updateCategory(Long id, Category category) {
        category.setId(id);
        return categoryRepo.save(category);
    }

    public void deleteCategory(Long id) {
        categoryRepo.deleteById(id);
    }

    // --- Currency ---

    public List<Currency> getAllCurrencies() {
        return currencyRepo.findAll();
    }

    public Currency createCurrency(Currency currency) {
        return currencyRepo.save(currency);
    }

    public Currency updateCurrency(Long id, Currency currency) {
        currency.setId(id);
        return currencyRepo.save(currency);
    }

    public void deleteCurrency(Long id) {
        currencyRepo.deleteById(id);
    }

    // --- Tag ---

    public List<Tag> getAllTags() {
        return tagRepo.findAll();
    }

    public Tag createTag(Tag tag) {
        return tagRepo.save(tag);
    }

    public Tag updateTag(Long id, Tag tag) {
        tag.setId(id);
        return tagRepo.save(tag);
    }

    public void deleteTag(Long id) {
        tagRepo.deleteById(id);
    }

    // --- Payment Method ---

    public List<PaymentMethod> getAllPaymentMethods() {
        return paymentMethodRepo.findAll();
    }

    public PaymentMethod createPaymentMethod(PaymentMethod paymentMethod) {
        return paymentMethodRepo.save(paymentMethod);
    }

    public PaymentMethod updatePaymentMethod(Long id, PaymentMethod paymentMethod) {
        paymentMethod.setId(id);
        return paymentMethodRepo.save(paymentMethod);
    }

    public void deletePaymentMethod(Long id) {
        paymentMethodRepo.deleteById(id);
    }
}
