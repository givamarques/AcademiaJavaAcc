package io.machine.machine.io.service;

import io.machine.machine.io.model.Operador;
import io.machine.machine.io.repository.OperadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


@Service
public class OperadorService {

    @Autowired
    OperadorRepository operadorRepository;

    public List<Operador> getAllOperador(){
        List<Operador> operadores = new ArrayList<Operador>();
        operadorRepository.findAll().forEach(operadores::add);
        return operadores;
    }

}
