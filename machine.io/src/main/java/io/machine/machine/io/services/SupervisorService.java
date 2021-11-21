package io.machine.machine.io.services;

import io.machine.machine.io.customExceptions.ResourceNotFoundException;
import io.machine.machine.io.models.Maquina;
import io.machine.machine.io.models.Operador;
import io.machine.machine.io.models.Supervisor;
import io.machine.machine.io.repositories.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupervisorService {

    @Autowired
    SupervisorRepository supervisorRepository;

    public List<Supervisor> findAll() {
        return (List<Supervisor>) supervisorRepository.findAll();
    }

    public Supervisor findById(Long id){
        Optional<Supervisor> obj = supervisorRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Supervisor save(Supervisor supervisor){
        return supervisorRepository.save(supervisor);
    }

    public void removeById(Long id){
        try{
            supervisorRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        } catch (RuntimeException e){
            e.printStackTrace();
        }
    }

    public Supervisor update(Long id, Supervisor obj){
        Supervisor entity = supervisorRepository.getById(id);
        updateData(entity, obj);
        return supervisorRepository.save(entity);
    }

    private void updateData(Supervisor entity, Supervisor obj) {
        entity.setNomeCompleto(obj.getNomeCompleto());
        entity.setRamal(obj.getRamal());
        entity.setOperacao(obj.getOperacao());
        entity.setTelefone(obj.getTelefone());
        entity.setListarOperadores(obj.getListarOperadores());
    }

}
