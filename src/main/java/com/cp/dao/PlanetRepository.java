package com.cp.dao;


import com.cp.model.CrewMember;
import com.cp.model.Planet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlanetRepository
    extends CrudRepository<Planet, Long> {
    Optional<CrewMember> findByName(String name) throws IllegalArgumentException;

}
