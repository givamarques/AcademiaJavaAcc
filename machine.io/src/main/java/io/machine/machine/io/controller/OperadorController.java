package io.machine.machine.io.controller;

import io.machine.machine.io.model.Operador;
import io.machine.machine.io.service.OperadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OperadorController {

    @Autowired
    private OperadorService operadorService;

    @RequestMapping(value = "/operadores")
    private List<Operador> getAllOperador(){
        return operadorService.getAllOperador();
    }
}
