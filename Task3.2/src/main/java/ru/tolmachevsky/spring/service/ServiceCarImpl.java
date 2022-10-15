package ru.tolmachevsky.spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.tolmachevsky.spring.dao.CarDao;
import ru.tolmachevsky.spring.models.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCarImpl implements ServiceCar {
    @Autowired
    private CarDao carDao;

    @Override
    @Transactional
    public void addCar(Car car) {
        carDao.addCar(car);
    }

    @Override
    public List <Car> getResponse(int count) {
        return carDao.getResponse(count);
    }
    @Override
    public List <Car> getAllCars(){
        return carDao.getAllCars();
    }

}
