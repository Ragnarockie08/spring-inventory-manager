package com.codecool.springinventorymanager.controller;


import com.codecool.springinventorymanager.form.InventoryForm;
import com.codecool.springinventorymanager.model.Inventory;
import com.codecool.springinventorymanager.service.EmployeeService;
import com.codecool.springinventorymanager.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/inventory")
public class InventoryController {

    private InventoryService service;
    private EmployeeService employeeService;

    @Autowired
    public InventoryController(InventoryService service, EmployeeService employeeService) {
        this.service = service;
        this.employeeService = employeeService;
    }

    @GetMapping("/index")
    public String index(Model model){

        model.addAttribute("items", service.getAll());

        return "inventory/displayHome";
    }

    @GetMapping("/index/{id}")
    public String findOne(@PathVariable Long id, Model model){

        model.addAttribute("item", service.findById(id));
        model.addAttribute("message", "Details of item with id: " + id);

        return "inventory/display";
    }

    @GetMapping("/add")
    public String displayForm(Model model){

        InventoryForm form = new InventoryForm();
        model.addAttribute("inventoryForm", form);
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("message", "Added new item");

        return "inventory/create";
    }

    @GetMapping("/edit/{id}")
    public String displayUpdate(@PathVariable Long id, Model model){

        Inventory inv = service.findById(id);
        InventoryForm form = new InventoryForm();
        model.addAttribute("inventoryForm", form);
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("item", inv);

        return "inventory/update";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute("inventoryForm") InventoryForm form, Model model){

        Inventory inv = service.save(form);
        model.addAttribute("item", inv);

        return "inventory/display";
    }

    @PutMapping("/edit/{id}")
    public String update(@ModelAttribute InventoryForm form, @PathVariable Long id,  Model model){

        Inventory inv = service.update(id, form);
        model.addAttribute("item", inv);
        model.addAttribute("message", "Update item with id: " + id);

        return "inventory/display";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model){

        model.addAttribute("item", service.findById(id));
        model.addAttribute("message", "Remove item with id: " + id);

        service.delete(id);

        return "inventory/display";
    }


}
