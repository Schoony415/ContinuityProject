package com.cp.dao;

import com.cp.model.CrewMember;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrewMemberRepository
        extends CrudRepository<CrewMember, Long> {

}
