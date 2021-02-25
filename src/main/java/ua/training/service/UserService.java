package ua.training.service;

import ua.training.dao.DaoFactory;
import ua.training.dao.UserDAO;
import ua.training.dao.impl.JDBCUserDao;
import ua.training.model.User;

import java.util.List;
import java.util.Optional;

public class UserService {
    DaoFactory daoFactory = DaoFactory.getInstance();

    public Optional<User> login(String login){
        Optional<User> result;
        try(UserDAO userDAO = daoFactory.createUserDAO()){
            result = userDAO.findByLogin(login);
        }

        return result;
    }

    public void addUser(User user){
        try(UserDAO userDAO = daoFactory.createUserDAO()){
            System.out.println(user.getFirstName()+ " from service");
            userDAO.add(user);
        }
    }

    public List<User> findAll() {
        try(UserDAO dao = daoFactory.createUserDAO()){
            return dao.findAll();
        }
    }

    public void changeRole(int userId, String role) {
        try(UserDAO dao = daoFactory.createUserDAO()){
            dao.changeRole(userId, role);
        }
    }
}
