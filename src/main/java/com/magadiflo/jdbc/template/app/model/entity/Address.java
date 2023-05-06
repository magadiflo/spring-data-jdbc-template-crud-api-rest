package com.magadiflo.jdbc.template.app.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Esta clase es un Aggregate
 * ***************************
 * Conjunto de entidades de dominio que está
 * estrechamente relacionado con otras y que
 * forman un todo, un único conjunto. Por ejemplo,
 * un Customer tiene una dirección y una dirección
 * no puede existir sin tener asociado un Customer.
 */

@Table(name = "addresses")
public class Address {
    @Id
    private Long id;
    private String street;
    private String country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Address{");
        sb.append("id=").append(id);
        sb.append(", street='").append(street).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
