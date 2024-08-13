package com.autopedia.api.domain;

import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class CrudService<T, ID> {

    protected final JpaRepository<T, ID> repository;

    public CrudService(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    public void save(T entity) {
        this.repository.save(entity);
    }

    public T findById(ID id) {
        return this.repository.findById(id).orElse(null); // use orElse(null) to avoid NoSuchElementException
    }

    public Page<DTO> findAll(Pageable pageable, Function<T, DTO> converter) {
        return this.repository.findAll(pageable).map(converter);
    }

    public void deleteById(ID id) {
        this.repository.deleteById(id);
    }
}
