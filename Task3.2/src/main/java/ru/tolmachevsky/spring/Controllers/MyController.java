package ru.tolmachevsky.spring.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.tolmachevsky.spring.config.AppConfig;
import ru.tolmachevsky.spring.service.ServiceCar;

import javax.servlet.http.HttpServletRequest;

@PropertySource("classpath:mycontroller.properties")
@Controller
public class MyController {

    @Autowired
    private Environment env;

    static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    static ServiceCar serviceCar = context.getBean(ServiceCar.class);

    @GetMapping("/cars")
    public String sayHello(HttpServletRequest request, Model model){
        String count = request.getParameter("count");
        int maxCar = Integer.parseInt(env.getProperty("maxCar"));
        if (count != null && Integer.parseInt(count) < maxCar ) {
            model.addAttribute("cars", serviceCar.getResponse(Integer.parseInt(count)));
        } else {
            model.addAttribute("cars",serviceCar.getAllCars());
        }
        return "cars";
    }

}
