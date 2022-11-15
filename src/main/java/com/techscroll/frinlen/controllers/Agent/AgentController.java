package com.techscroll.frinlen.controllers.Agent;

import com.techscroll.frinlen.Entity.Agent.Agent;
import com.techscroll.frinlen.Entity.Customer.Customer;
import com.techscroll.frinlen.Service.Agent.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/agents")
public class AgentController {

    @Autowired
    private AgentService agentService;
    @GetMapping
    public ResponseEntity<List<Agent>> getAllCustomers()
    {
        return new ResponseEntity( agentService.getAllAgents(), HttpStatus.OK);
    }
}
