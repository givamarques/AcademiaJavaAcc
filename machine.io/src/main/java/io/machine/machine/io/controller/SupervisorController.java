package io.machine.machine.io.controller;

import io.machine.machine.io.model.Supervisor;
import io.machine.machine.io.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SupervisorController {

    @Autowired
    private SupervisorService supervisorService;

    @RequestMapping(value = "/supervisores")
    private List<Supervisor> getAllSupervisor() {
        return supervisorService.getAllSupervisor();
    }
}
