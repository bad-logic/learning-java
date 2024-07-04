package com.example.lab.common;

import java.util.List;

public interface CustomService<D, I> {
    List<D> getAll();

    D getById(I id);

    D add(D data);

    D patch(D data);

    I deleteById(I id);
    
}
