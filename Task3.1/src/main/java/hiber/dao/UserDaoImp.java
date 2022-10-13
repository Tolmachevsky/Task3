package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Override
    public void addCar(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public void dropAllTables() {
        sessionFactory.getCurrentSession().createNativeQuery("drop table user").executeUpdate();
        sessionFactory.getCurrentSession().createNativeQuery("drop table car").executeUpdate();
        sessionFactory.getCurrentSession().createNativeQuery("drop table hibernate_sequence").executeUpdate();
    }


    @Override
    public User getUserByCar(String model, int series) {
        Car car = sessionFactory.getCurrentSession().createQuery("from Car where model = '" + model + "' and series = " + series, Car.class).getSingleResult();
        User user = sessionFactory.getCurrentSession().createQuery("from User where car_id = " + car.getId(), User.class).getSingleResult();
        return user;
    }

}
