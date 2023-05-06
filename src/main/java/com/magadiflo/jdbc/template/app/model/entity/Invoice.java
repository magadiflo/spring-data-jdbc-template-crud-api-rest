package com.magadiflo.jdbc.template.app.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Table(name = "invoices")
public class Invoice {
    @Id
    private Long id;
    private String number;
    private Double total;
    private Date createAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Invoice{");
        sb.append("id=").append(id);
        sb.append(", number='").append(number).append('\'');
        sb.append(", total=").append(total);
        sb.append(", createAt=").append(createAt);
        sb.append('}');
        return sb.toString();
    }
}
