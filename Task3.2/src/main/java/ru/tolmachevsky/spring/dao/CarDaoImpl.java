package ru.tolmachevsky.spring.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.tolmachevsky.spring.model.Car;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImpl implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public void addCar(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Transactional
    @Override
    public List<Car> getCars(int count) {
        List<Car> list = sessionFactory.getCurrentSession().createQuery("from Car", Car.class).list().stream()
                .limit(count)
                .collect(Collectors.toList());

        return list;
    }

    @Transactional
    @Override
    public List<Car> getAllCars() {
        return sessionFactory.getCurrentSession().createQuery("from Car", Car.class).list();
    }
}
