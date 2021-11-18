package io.machine.machine.io.services;

import io.machine.machine.io.models.Operador;
import io.machine.machine.io.repositories.OperadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Optional<Operador> buscarById(Long id){
        return operadorRepository.findById(id);
    }

    public Operador save(Operador operador){
        return operadorRepository.save(operador);
    }

    public void removeById(Long id){
        operadorRepository.deleteById(id);
    }


}
