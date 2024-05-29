package com.example.lab01.common;

import java.util.List;
import java.util.Optional;

public interface Repository<I, D> {
    void save(D data);

    Optional<D> get(I id);

    List<D> get();

    D update(I id, D data);

    void delete(I id);
}
