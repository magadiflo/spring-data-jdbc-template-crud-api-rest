package com.magadiflo.jdbc.template.app.service.impl;

import com.magadiflo.jdbc.template.app.model.entity.Customer;
import com.magadiflo.jdbc.template.app.repository.ICustomerRepository;
import com.magadiflo.jdbc.template.app.service.ICustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {
    private final ICustomerRepository customerRepository;

    public CustomerServiceImpl(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Customer> findAll() {
        return (List<Customer>) this.customerRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Customer> findById(Long id) {
        return this.customerRepository.findById(id);
    }

    @Override
    @Transactional
    public Customer save(Customer customer) {
        return this.customerRepository.save(customer);
    }

    @Override
    @Transactional
    public Optional<Customer> update(Long id, Customer customer) {
        return this.customerRepository.findById(id)
                .map(customerDB -> {
                    customerDB.setName(customer.getName());
                    customerDB.setPhone(customer.getPhone());
                    customerDB.setInvoices(customer.getInvoices());
                    customerDB.setAddress(customer.getAddress());
                    return Optional.of(this.customerRepository.save(customerDB));
                })
                .orElseGet(Optional::empty);
    }

    @Override
    @Transactional
    public Optional<Boolean> deleteById(Long id) {
        return this.customerRepository.findById(id)
                .map(customerDB -> {
                    this.customerRepository.deleteById(id);
                    return Optional.of(true);
                })
                .orElseGet(Optional::empty);
    }
}
