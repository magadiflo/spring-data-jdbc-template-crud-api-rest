package com.magadiflo.jdbc.template.app.service;

import com.magadiflo.jdbc.template.app.model.User;
import com.magadiflo.jdbc.template.app.model.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<Customer> findAll();

    Optional<Customer> findById(Long id);

    Customer save(Customer customer);

    Optional<Customer> update(Long id, Customer customer);

    Optional<Boolean> deleteById(Long id);
}
