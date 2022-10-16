package ru.tolmachevsky.spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tolmachevsky.spring.dao.CarDao;
import ru.tolmachevsky.spring.model.Car;

import java.util.List;

@Service
@PropertySource("classpath:userController.properties")
public class CarServiceImpl implements CarService {
    @Value("${maxCar}")
    private String maxCar;
    @Autowired
    private CarDao carDao;

    @Override
    @Transactional
    public void addCar(Car car) {
        carDao.addCar(car);
    }

    @Override
    public List<Car> getResponse(String count) {
        if (count != null && Integer.parseInt(count) < Integer.parseInt(maxCar)) {
            return carDao.getResponse(Integer.parseInt(count));
        } else {
            return carDao.getAllCars();
        }
    }

    @Override
    public List<Car> getAllCars() {
        return carDao.getAllCars();
    }

}
