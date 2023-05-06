package com.magadiflo.jdbc.template.app.repository;

import com.magadiflo.jdbc.template.app.model.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerRepository extends CrudRepository<Customer, Long> {
}
