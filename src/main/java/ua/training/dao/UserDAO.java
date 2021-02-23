package ua.training.dao;

import ua.training.model.User;

import java.util.Optional;

public interface UserDAO extends GenericDAO<User>{
    Optional<User> findByLogin(String login);
}
