package com.magadiflo.jdbc.template.app.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.HashSet;
import java.util.Set;

/**
 * OneToMany
 * Customer 1 -- * Invoice
 */

@Table(name = "customers")
public class Customer {
    @Id
    private Long id;
    private String name;
    private String phone;
    /**
     * keyColumn="id", nombre de la clave primaria de la tabla Invoice.
     * idColumn="customer_id", nombre de la clave foránea que hace referencia a la tabla Customer en la tabla Invoice.
     */
    @MappedCollection(keyColumn = "id", idColumn = "customer_id")
    private Set<Invoice> invoices = new HashSet<>();

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", invoices=").append(invoices);
        sb.append('}');
        return sb.toString();
    }
}
