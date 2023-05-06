package com.magadiflo.jdbc.template.app.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.HashSet;
import java.util.Set;

/**
 * Esta clase es un Aggregate Root o Entidad raíz
 * **********************************************
 * Cada agregado que se define tiene una entidad raíz de
 * la que colgarán el resto de entidades.
 * Una entidad raíz no tiene otra entidad de la que dependa,
 * sino que es la raíz de las demás entidades.
 */

@Table(name = "customers")
public class Customer {
    @Id
    private Long id;
    private String name;
    private String phone;

    /**
     * OneToMany [Customer 1 -- * Invoice]
     * ***********************************
     * keyColumn="id", nombre de la clave primaria de la tabla Invoice.
     * idColumn="customer_id", nombre de la clave foránea que hace referencia a la tabla Customer en la tabla Invoice.
     */
    @MappedCollection(keyColumn = "id", idColumn = "customer_id")
    private Set<Invoice> invoices = new HashSet<>();

    /**
     * OneToOne [Customer 1 -- 1 Address]
     * **********************************
     * customer_id, corresponde al nombre de la columna (fokeing key)
     * en la tabla addresses
     */
    @Column(value = "customer_id")
    private Address address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(Set<Invoice> invoices) {
        this.invoices = invoices;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", invoices=").append(invoices);
        sb.append(", address=").append(address);
        sb.append('}');
        return sb.toString();
    }
}
