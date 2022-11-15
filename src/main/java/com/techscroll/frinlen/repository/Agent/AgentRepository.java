package com.techscroll.frinlen.repository.Agent;

import com.techscroll.frinlen.Entity.Agent.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgentRepository extends JpaRepository<Agent,Long> {
    //List<Agent> findByMobileContaining(String mobile);
}
