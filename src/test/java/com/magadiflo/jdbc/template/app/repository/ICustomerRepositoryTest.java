package com.magadiflo.jdbc.template.app.repository;

import com.magadiflo.jdbc.template.app.model.entity.Customer;
import com.magadiflo.jdbc.template.app.model.entity.Invoice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class ICustomerRepositoryTest {

    @Autowired
    private ICustomerRepository customerRepository;


    @Test
    @DisplayName(value = "One-To-Many Mapping Test")
    void mappingTest() {
        Customer customer = new Customer();
        customer.setName("Tinkler");
        customer.setPhone("943859658");

        Set<Invoice> invoices = new HashSet<>();
        invoices.add(invoice1());
        invoices.add(invoice2());

        customer.setInvoices(invoices);

        Customer customerDB = customerRepository.save(customer);
        System.out.println(customerDB);
        Assertions.assertNotNull(customerDB);
    }

    private static Invoice invoice1() {
        Invoice invoice = new Invoice();
        invoice.setNumber("F02-010");
        invoice.setTotal(605.50);
        return invoice;
    }

    private static Invoice invoice2() {
        Invoice invoice = new Invoice();
        invoice.setNumber("F02-011");
        invoice.setTotal(100.20);
        return invoice;
    }
}