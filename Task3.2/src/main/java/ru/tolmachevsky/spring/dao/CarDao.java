package ru.tolmachevsky.spring.dao;

import ru.tolmachevsky.spring.models.Car;

import java.util.List;

public interface CarDao {

    public void addCar(Car car);
    List <Car> getResponse(int count);

    List <Car> getAllCars();

}
