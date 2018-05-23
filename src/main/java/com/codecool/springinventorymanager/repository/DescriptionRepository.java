package com.codecool.springinventorymanager.repository;

import com.codecool.springinventorymanager.model.Description;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescriptionRepository extends CrudRepository<Description, Long> {
}
