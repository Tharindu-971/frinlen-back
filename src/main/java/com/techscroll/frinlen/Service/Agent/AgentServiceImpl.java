package com.techscroll.frinlen.Service.Agent;

import com.techscroll.frinlen.Entity.Agent.Agent;
import com.techscroll.frinlen.repository.Agent.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentServiceImpl implements AgentService{

    @Autowired
    private AgentRepository agentRepository;

    @Override
    public List<Agent> getAllAgents(){
        return agentRepository.findAll();
    }

    @Override
    public Agent createAgent(Agent agent){
        Agent res = agentRepository.save(agent);
        return res;
    }
}
