package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

@Repository
@Transactional
public class UserDaoImpl extends AbstractJpaDao<User> {

    @Override
    public User getById(int id) {
        User user = em.find(User.class, id);
        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        em.createNativeQuery("CREATE TABLE IF NOT EXISTS `spring_hiber`.`users` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `firstname` VARCHAR(45) NOT NULL,\n" +
                "  `lastname` VARCHAR(45) NOT NULL,\n" +
                "  `email` VARCHAR(45) NOT NULL,\n" +
                "  PRIMARY KEY (`id`));").executeUpdate();
        List<User> users = em.createQuery("SELECT user FROM User user").getResultList();
        return users;
    }

    @Override
    public void create(User user) {
        em.persist(user);
    }

    @Override
    public void update(User user) {
        em.merge(user);
    }

    @Override
    public void delete(User user) {
        em.remove(user);
    }

    @Override
    public void deleteById(int userId) {
        em.remove(getById(userId));
    }
}
