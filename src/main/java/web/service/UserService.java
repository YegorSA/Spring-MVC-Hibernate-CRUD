package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    public void firstLoad();

    User getById(int id );

    List< User > findAll();

    void create(User user);

    void update(User user);

    void delete(User user);

    void deleteById( int entityId );
}
