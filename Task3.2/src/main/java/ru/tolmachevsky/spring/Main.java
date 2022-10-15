package ru.tolmachevsky.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.tolmachevsky.spring.config.AppConfig;
import ru.tolmachevsky.spring.model.Car;
import ru.tolmachevsky.spring.service.ServiceCar;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        ServiceCar serviceCar = context.getBean(ServiceCar.class);
        serviceCar.addCar(new Car("Tesla", "Model3", 21000));
        serviceCar.addCar(new Car("Tesla", "X", 89000));
        serviceCar.addCar(new Car("Tesla", "S", 57000));
        serviceCar.addCar(new Car("Toyota", "Supra", 77000));
        serviceCar.addCar(new Car("Toyota", "Camry", 25000));
        serviceCar.addCar(new Car("Dodge", "Charger", 31000));
        serviceCar.addCar(new Car("Ford", "Explorer", 39000));
        serviceCar.addCar(new Car("Bugatti", "Chiron", 2090000));
        serviceCar.addCar(new Car("Audi", "A8", 99000));
        serviceCar.addCar(new Car("Mercedes", "ML", 78000));
    }
}
