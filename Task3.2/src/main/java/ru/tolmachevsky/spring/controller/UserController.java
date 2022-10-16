package ru.tolmachevsky.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.tolmachevsky.spring.service.CarService;

@Controller
public class UserController {
    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public String getCars
            (@RequestParam("count") Integer count, Model model) {
        model.addAttribute("cars", carService.getCars(count));
        return "cars";
    }
}
