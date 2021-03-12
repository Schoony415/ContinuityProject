package com.cp.dao;

import com.cp.model.CrewMember;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CrewMemberRepository
        extends CrudRepository<CrewMember, Long> {
    Optional<CrewMember> findByName(String name) throws IllegalArgumentException;

}
