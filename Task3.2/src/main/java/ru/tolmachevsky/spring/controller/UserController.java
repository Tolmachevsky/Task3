package ru.tolmachevsky.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.tolmachevsky.spring.service.ServiceCar;

@Controller
public class UserController {
    @Autowired
    private ServiceCar serviceCar;

    @GetMapping("/cars")
    public String cars(@RequestParam("count") String count, Model model) {
        model.addAttribute("cars", serviceCar.getResponse(count));
        return "cars";
    }
}
