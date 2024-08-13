package com.autopedia.api.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class CrudService<T, ID, R extends JpaRepository<T, ID>> {

    protected final R repository;

    public CrudService(R repository) {
        this.repository = repository;
    }

    public void save(T entity) {
        this.repository.save(entity);
    }

    public T findById(ID id) {
        return this.repository.findById(id).orElse(null); // use orElse(null) to avoid NoSuchElementException
    }

    public List<T> findAll() {
        return this.repository.findAll();
    }

    public void deleteById(ID id) {
        this.repository.deleteById(id);
    }
}
