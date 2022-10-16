package ru.tolmachevsky.spring.service;

import org.springframework.ui.Model;
import ru.tolmachevsky.spring.model.Car;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ServiceCar {
    void addCar(Car car);

    List <Car> getResponse(String count);

    List<Car> getAllCars();
}
