package ua.training.dao;

import ua.training.model.Role;
import ua.training.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO_old {
    private final List<User> store = new ArrayList<>();

    public User getById(int id){
        User result = new User();
        result.setId(-1);

        for(User user : store){
            if(user.getId()==id){
                result = user;
            }
        }
        return result;

    }

    public User getUserByLoginPassword(final String login, final String password){
        User result = new User();
        result.setId(-1);
        for(User user : store){
            if(user.getLogin().equals(login) && user.getPassword().equals(password)){
                result = user;
            }
        }
        return result;
    }

    public  boolean add(User user){
        for(User u : store){
            if(u.getLogin().equals(user.getLogin())){
                return false;
            }
        }
        return store.add(user);
    }

    public Role getRoleByLoginPassword(final String login, final String password){
        Role result = Role.GUEST;
        for(User user : store){
            if(user.getLogin().equals(login) && user.getPassword().equals(password)){
                result = user.getRole();
            }
        }
        return result;
    }

    public boolean userIsExist(final String login, final  String password){
        boolean result = false;
        for(User user : store){
            if(user.getLogin().equals(login) && user.getPassword().equals(password)){
                result = true;
                break;
            }
        }
        return result;
    }
}
