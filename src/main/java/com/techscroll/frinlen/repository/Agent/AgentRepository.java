package com.techscroll.frinlen.repository.agent;

import com.techscroll.frinlen.entity.agent.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository<Agent,Long> {
}
