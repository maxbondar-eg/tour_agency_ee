package ua.training.dao.impl;

import ua.training.dao.DaoFactory;
import ua.training.dao.TourDAO;
import ua.training.dao.TourOrderDAO;
import ua.training.dao.UserDAO;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {

    private DataSource dataSource = ConnectionPoolHolder.getDataSource();

    public UserDAO createUserDAO() {
        return new JDBCUserDao(getConnection());
    }
    public TourDAO createTourDAO() {
        return new JDBCTourDao(getConnection());
    }
    public TourOrderDAO createTourOrderDAO() {
        return new JDBCTourOrderDao(getConnection());
    }

    private Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
