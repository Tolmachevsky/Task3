package ru.tolmachevsky.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Car implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String brand;

    private String model;

    private Integer price;

    public Car(String brand, String model, Integer price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public Car() {
    }

    @Override
    public String toString() {
        return "Car:"
                + brand
                + " "
                + model
                + ", price=" + price + "$";
    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
