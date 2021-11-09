package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.dao.UserDaoImpl;
import web.model.User;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    private final UserDaoImpl userDaoImpl;

    @Autowired
    public UserServiceImpl(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @Override
    @PostConstruct
    public void firstLoad(){
        if (userDaoImpl.findAll().isEmpty()) {
            String defaultFirstname = "Иван";
            String defaultLastname = "Иванов";
            String defaultEmail = "ivan007@mail.ru";
            User defaultUser = new User(defaultFirstname, defaultLastname, defaultEmail);
            userDaoImpl.create(defaultUser);
        }
    }

    @Override
    public User getById(int id) {
        return userDaoImpl.getById(id);
    }

    @Override
    public List<User> findAll() {
        return userDaoImpl.findAll();
    }

    @Override
    public void create(User user) {
        userDaoImpl.create(user);
    }

    @Override
    public void update(User user) {
        userDaoImpl.update(user);
    }

    @Override
    public void delete(User user) {
        userDaoImpl.delete(user);
    }

    @Override
    public void deleteById(int entityId) {
        userDaoImpl.deleteById(entityId);
    }
}
