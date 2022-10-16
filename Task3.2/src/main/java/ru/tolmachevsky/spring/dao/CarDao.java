package ru.tolmachevsky.spring.dao;

import ru.tolmachevsky.spring.model.Car;

import java.util.List;

public interface CarDao {

    void addCar(Car car);

    List<Car> getCars(int count);

    List<Car> getAllCars();

}
