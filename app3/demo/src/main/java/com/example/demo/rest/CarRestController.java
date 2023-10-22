package com.example.demo.rest;


import com.example.demo.dao.BaseDAO;

import com.example.demo.dao.CarDAOImpl;
import com.example.demo.entity.BaseResponse;
import com.example.demo.entity.Car;
import com.example.demo.entity.CarForm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpClient;

@Controller
public class CarRestController {

    private BaseDAO<Car> carDAO;

    @Autowired
    public CarRestController(BaseDAO<Car> carDAO){
        this.carDAO = carDAO;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable int id, Model model) {
        Car car = carDAO.find(id);
        if (car == null) {
            car = new Car("s", "s", 0);
        }
        model.addAttribute("car", car);
        return "get-car";
    }

    @PostMapping("/")
    public String create(@Valid @ModelAttribute("car") CarForm car, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("Error" + result.getAllErrors());
            return "home";
        }
        Car c = new Car(car.getName(), car.getBrand(), car.getYear());
        carDAO.save(c);
        System.out.println("No Error" + result.getAllErrors());

        return "home";

    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("car", new CarForm());
        return "home";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable int id,@Valid @ModelAttribute("car") Car car, Model model){
         Car c = carDAO.Update(id, car);
         model.addAttribute("car", c);
         return "get-car";

    }
//
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        if (id > 0) {
            carDAO.delete(id);
            return "delete-confirm";
        }
        return "home";
    }
}
