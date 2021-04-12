package com.cp.dao;

import com.cp.model.CrewMember;
import com.cp.model.SolarSystemThin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SolarSystemRepository
        extends CrudRepository<SolarSystemThin, Long> {
    Optional<SolarSystemThin> findBySolarName(String solarName) throws IllegalArgumentException;
}
