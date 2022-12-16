package com.techscroll.frinlen.Service.Agent;

import com.techscroll.frinlen.Entity.Agent.Agent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AgentService {
    List<Agent> getAllAgents();

    Agent createAgent(Agent agent);
}
