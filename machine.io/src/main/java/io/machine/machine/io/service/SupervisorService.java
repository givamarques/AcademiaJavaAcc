package io.machine.machine.io.service;

import io.machine.machine.io.model.Operador;
import io.machine.machine.io.model.Supervisor;
import io.machine.machine.io.repository.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SupervisorService {

    @Autowired
    SupervisorRepository supervisorRepository;
    public List<Supervisor> findAll() {
        return (List<Supervisor>) supervisorRepository.findAll();
    }

    public Optional<Supervisor> buscarById(Long id){
        return supervisorRepository.findById(id);
    }

    public Supervisor save(Supervisor supervisor){
        return supervisorRepository.save(supervisor);
    }

    public void removeById(Long id){
        supervisorRepository.deleteById(id);
    }

}
