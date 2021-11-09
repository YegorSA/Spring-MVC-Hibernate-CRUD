package web.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class AbstractJpaDao<T> {

    @PersistenceContext
    EntityManager em;

    public abstract T getById(int id);

    public abstract List<T> findAll();

    public abstract void create(T user);

    public abstract void update(T user);

    public abstract void delete(T user);

    public abstract void deleteById(int userId);
}