package io.machine.machine.io.services;

import io.machine.machine.io.customExceptions.ResourceNotFoundException;
import io.machine.machine.io.models.Maquina;
import io.machine.machine.io.models.Operador;
import io.machine.machine.io.repositories.OperadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OperadorService {

    @Autowired
    OperadorRepository operadorRepository;

    public List<Operador> findAll() {
        return (List<Operador>) operadorRepository.findAll();
    }

    public Operador findById(Long id){
        Optional<Operador> obj = operadorRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Operador save(Operador operador){
        return operadorRepository.save(operador);
    }

    public void removeById(Long id){
        try{
            operadorRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        } catch (RuntimeException e){
            e.printStackTrace();
        }
    }

    public Operador update(Long id, Operador obj){
        Operador entity = operadorRepository.getById(id);
        updateData(entity, obj);
        return operadorRepository.save(entity);
    }

    private void updateData(Operador entity, Operador obj) {
        entity.setOperacao(obj.getOperacao());
        entity.setSupervisorOperador(obj.getSupervisorOperador());
        entity.setNomeCompleto(obj.getNomeCompleto());
        entity.setTelefone(obj.getTelefone());
    }


}
