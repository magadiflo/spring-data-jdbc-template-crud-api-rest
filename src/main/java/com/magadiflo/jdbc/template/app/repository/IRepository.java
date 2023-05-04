package com.magadiflo.jdbc.template.app.repository;

import java.util.List;
import java.util.Optional;

public interface IRepository<T, I> {
    List<T> findAll();

    Optional<T> findById(I id);

    int save(T t);

    Long saveAndReturnId(T t);

    int update(T t);

    int deleteById(I id);
}
