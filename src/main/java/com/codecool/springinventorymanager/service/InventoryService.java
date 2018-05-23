package com.codecool.springinventorymanager.service;

import com.codecool.springinventorymanager.form.InventoryForm;
import com.codecool.springinventorymanager.model.Description;
import com.codecool.springinventorymanager.model.Inventory;
import com.codecool.springinventorymanager.repository.EmployeeRepository;
import com.codecool.springinventorymanager.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class InventoryService {

    private InventoryRepository inventoryRepository;
    private EmployeeRepository employeeRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository,
                            EmployeeRepository employeeRepository) {
        this.inventoryRepository = inventoryRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<Inventory> getAll(){

        List<Inventory> items = new ArrayList<>();
        inventoryRepository.findAll().forEach(items::add);
        return items;
    }

    public Inventory findById(Long id){

        Optional<Inventory> inv = inventoryRepository.findById(id);

        return inv.orElse(null);
    }

    public Inventory save(InventoryForm form){

        Inventory inv = new Inventory(form.getName(), form.getManufacturer(),
                form.getCategory(), form.getCost(), form.getStatus());

        inv.setDescription(new Description(form.getText()));
        inv.setCode(UUID.randomUUID());
        inv.setBuyingDate(parseDate(form.getBuyingDate()));
        inv.setOwner(employeeRepository.findById(form.getOwner()).orElse(null));

        inv.setCode(UUID.randomUUID());

        inventoryRepository.save(inv);

        return inv;
    }

    public Inventory update(Long id, InventoryForm form){

        Inventory inv = findById(id);

        inv.setName(form.getName());
        inv.getDescription().setText(form.getText());
        inv.setManufacturer(form.getManufacturer());
        inv.setCategory(form.getCategory());
        inv.setBuyingDate(parseDate(form.getBuyingDate()));
        inv.setStatus(form.getStatus());
        inv.setCost(form.getCost());
        inv.setOwner(employeeRepository.findById(form.getOwner()).orElse(null));

        inventoryRepository.save(inv);

        return inv;
    }

    public void delete(Long id){

        inventoryRepository.deleteById(id);
    }

    private Date parseDate(String toParse){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        Date date = new Date();

        try {
            date = format.parse(toParse);
        } catch (ParseException e){
            System.out.println("Wrong date format");
        }

        return date;
    }
}
