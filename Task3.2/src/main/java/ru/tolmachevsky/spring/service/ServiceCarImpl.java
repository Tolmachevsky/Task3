package ru.tolmachevsky.spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import ru.tolmachevsky.spring.dao.CarDao;
import ru.tolmachevsky.spring.model.Car;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
@PropertySource("classpath:mycontroller.properties")
public class ServiceCarImpl implements ServiceCar {
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
    public void getResponse(HttpServletRequest request, Model model) {
        String count = request.getParameter("count");
        if (count != null && Integer.parseInt(count) < Integer.parseInt(maxCar)) {
            model.addAttribute("cars", carDao.getResponse(Integer.parseInt(count)));
        } else {
            model.addAttribute("cars", carDao.getAllCars());
        }
    }

    @Override
    public List<Car> getAllCars() {
        return carDao.getAllCars();
    }

}
