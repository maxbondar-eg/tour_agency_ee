package ua.training.dao.impl;

import ua.training.dao.TourOrderDAO;
import ua.training.model.TourOrder;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class JDBCTourOrderDao implements TourOrderDAO {

    private Connection connection;

    public JDBCTourOrderDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(TourOrder entity) {

    }

    @Override
    public Optional<TourOrder> findById(int id) {
        return null;
    }

    @Override
    public List<TourOrder> findAll() {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
