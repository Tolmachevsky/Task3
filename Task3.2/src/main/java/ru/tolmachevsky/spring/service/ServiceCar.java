package ru.tolmachevsky.spring.service;

import ru.tolmachevsky.spring.models.Car;

import java.util.List;

public interface ServiceCar {
    void addCar(Car car);

    List <Car> getResponse(int count);

    List <Car> getAllCars();
}
