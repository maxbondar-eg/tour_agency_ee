package ua.training.dao.impl;

import ua.training.dao.UserDAO;
import ua.training.dao.mapper.UserMapper;
import ua.training.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class JDBCUserDao implements UserDAO {

    private Connection connection;

    public static final String FIND_BY_LOGIN = "SELECT * FROM account WHERE login = ?";
    public static final String ADD_USER = "insert into account(login, password, first_name, last_name, role) values (?, ?, ?, ?, ?);";

    public JDBCUserDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(User user) {
        System.out.println(user.getLogin() + " from dao");
        try(PreparedStatement ps = connection.prepareStatement(ADD_USER)){
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFirstName());
            ps.setString(4, user.getLastName());
            ps.setString(5, user.getRole().name());
            ps.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public Optional<User> findById(int id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Optional<User> findByLogin(String login) {
        Optional<User> result = Optional.empty();
        try(PreparedStatement ps = connection.prepareCall(FIND_BY_LOGIN)){
            ResultSet rs;
            ps.setString(1, login);
            System.out.println(login);
            rs = ps.executeQuery();
            UserMapper mapper = new UserMapper();
            if(rs.next()){
                System.out.println(rs.getString("first_name") + " firstname");
                result = Optional.of(mapper.extractFromResultSet(rs));
                System.out.println(result.isPresent() + " result");
            }else{
                System.out.println("no found");
            }
        } catch (Exception ex){
            throw new RuntimeException(ex);
        }
        return result;
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
