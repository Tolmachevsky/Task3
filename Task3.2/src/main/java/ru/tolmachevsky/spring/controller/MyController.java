package ru.tolmachevsky.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.tolmachevsky.spring.service.ServiceCar;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyController {
    @Autowired
    private ServiceCar serviceCar;

    @GetMapping("/cars")
    public String cars(HttpServletRequest request, Model model) {
        serviceCar.getResponse(request, model);
        return "cars";
    }
}
