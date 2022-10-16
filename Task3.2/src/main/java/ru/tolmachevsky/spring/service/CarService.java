package ru.tolmachevsky.spring.service;

import ru.tolmachevsky.spring.model.Car;

import java.util.List;

public interface CarService {
    void addCar(Car car);

    List <Car> getResponse(String count);

    List<Car> getAllCars();
}
