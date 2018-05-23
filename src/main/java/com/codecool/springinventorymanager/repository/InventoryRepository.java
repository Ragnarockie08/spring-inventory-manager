package com.codecool.springinventorymanager.repository;

import com.codecool.springinventorymanager.model.Inventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, Long> {
}
