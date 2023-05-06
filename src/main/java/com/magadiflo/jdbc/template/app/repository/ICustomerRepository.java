package com.magadiflo.jdbc.template.app.repository;

import com.magadiflo.jdbc.template.app.model.entity.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Un repositorio, trabaja con el Aggregate Root, para obtener los agregados.
 * Si una entidad que forma parte de un agregado se tiene que persistir en la
 * base de datos se hará a través del Aggregate Root usando el repositorio
 * de esa entidad raíz para realizar la operación.
 * <p>
 * Es por eso que las operaciones para las entidades Address, Invoice, las
 * realizamos a través de este CrudRepository de Customer.
 */
public interface ICustomerRepository extends CrudRepository<Customer, Long> {
}
