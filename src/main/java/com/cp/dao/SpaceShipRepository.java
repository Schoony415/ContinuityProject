package com.cp.dao;

import com.cp.model.SpaceShip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpaceShipRepository
        extends CrudRepository<com.cp.model.SpaceShip, Long> {
    Optional<SpaceShip> findByName(String name) throws IllegalArgumentException;
}
