package com.codecool.springinventorymanager.controller;


import com.codecool.springinventorymanager.model.Employee;
import com.codecool.springinventorymanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/employees")
public class EmployeeController {

    private EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }


    @GetMapping("/index")
    public String index(Model model){

        model.addAttribute("employees", service.getAll());

        return "employee/displayAll";
    }

    @GetMapping("/add")
    public String displayForm(Model model){
        Employee emp = new Employee();
        model.addAttribute("employee", emp);

        return "employee/createEmp";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute Employee emp, Model model){

        model.addAttribute("employee", emp);
        service.save(emp);
        return "employee/displayEmp";
    }
}
