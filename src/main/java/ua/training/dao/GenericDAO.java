package ua.training.dao;

import ua.training.model.Tour;

import java.util.List;
import java.util.Optional;

public interface GenericDAO<T> extends AutoCloseable {
    void add(T entity);
    Optional<T> findById(int id);
    List<T> findAll();
    void delete(int id);
    void close();

    void edit(T entity);
}
