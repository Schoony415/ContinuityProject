package com.cp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpaceShipRepository extends CrudRepository<com.cp.model.SpaceShip, Long> {
}
