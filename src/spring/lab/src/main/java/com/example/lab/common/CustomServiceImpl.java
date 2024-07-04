package com.example.lab.common;

import java.util.List;
import java.util.Optional;

public class CustomServiceImpl<D, I> implements CustomService<D, I> {

    private final CustomRepository<D, I> repository;

    public CustomServiceImpl(CustomRepository<D, I> repository) {
        this.repository = repository;
    }

    @Override
    public D getById(I id) {
        Optional<D> u = this.repository.findById(id);
        return u.orElse(null);
    }

    @Override
    public List<D> getAll() {
        return this.repository.findAll();
    }

    @Override
    public D add(D p) {
        this.repository.save(p);
        return p;
    }

    @Override
    public D patch(D patch) {
        return this.repository.save(patch);
    }

    @Override
    public I deleteById(I id) {
        this.repository.deleteById(id);
        return id;
    }
}
