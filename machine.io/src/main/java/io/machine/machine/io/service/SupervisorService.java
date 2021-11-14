package io.machine.machine.io.service;

import io.machine.machine.io.model.Supervisor;
import io.machine.machine.io.repository.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupervisorService {

    @Autowired
    SupervisorRepository supervisorRepository;

    public List<Supervisor> getAllSupervisor() {
        List<Supervisor> supervisor = new ArrayList<Supervisor>();
        supervisorRepository.findAll().forEach(supervisor::add);
        return supervisor;
    }
}
