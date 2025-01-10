package org.example.repository;

import java.util.List;

public interface GenericRepository<T, ID > {
    T getByID(ID id);
    List<T> getAll();
    T create (T t);
    T update (T t);
    void deleteById(ID id);
}
