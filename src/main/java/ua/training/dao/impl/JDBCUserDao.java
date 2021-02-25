package ua.training.dao.impl;

import ua.training.dao.UserDAO;
import ua.training.dao.mapper.UserMapper;
import ua.training.model.Role;
import ua.training.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCUserDao implements UserDAO {

    private Connection connection;

    public static final String FIND_ALL = "select * from account";
    public static final String FIND_BY_LOGIN = "SELECT * FROM account WHERE login = ?";
    public static final String ADD_USER = "insert into account(login, password, first_name, last_name, role) values (?, ?, ?, ?, ?)";
    public static final String CHANGE_ROLE = "update account set role=? where id=?";

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
        List<User> result = new ArrayList<>();
        try(Statement st = connection.createStatement()){
            ResultSet rs = st.executeQuery(FIND_ALL);
            UserMapper mapper = new UserMapper();
            while (rs.next()){
                User user = mapper.extractFromResultSet(rs);
                result.add(user);
            }
        } catch (SQLException ex){
            ex.printStackTrace();
            throw new RuntimeException("Some troubles with database");
        }
        return result;
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
            rs = ps.executeQuery();
            UserMapper mapper = new UserMapper();
            if(rs.next()){
                result = Optional.of(mapper.extractFromResultSet(rs));
            }else{
                System.out.println("no found");
            }
        } catch (Exception ex){
            throw new RuntimeException(ex);
        }
        return result;
    }

    @Override
    public void changeRole(int userId, String role) {
        try(PreparedStatement ps = connection.prepareStatement(CHANGE_ROLE)){
            if(role.equals("ADMIN")){
                ps.setString(1, Role.USER.name());
            }else{
                ps.setString(1, Role.ADMIN.name());
            }
            ps.setInt(2, userId);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException("Database exception");
        }
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void edit(User entity) {

    }
}
