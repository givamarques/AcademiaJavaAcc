package io.machine.machine.io.controllers;

import io.machine.machine.io.models.Maquina;
import io.machine.machine.io.models.Operador;
import io.machine.machine.io.services.OperadorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/operador")
public class OperadorController {

    @Autowired
    private OperadorService operadorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Operador salvarOperador(@RequestBody Operador operador){
        return operadorService.save(operador);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Operador> listarOperadores(){
        return operadorService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Operador operadorPorId(@PathVariable("id") Long id){
        return operadorService.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> removerOperadorPorId(@PathVariable("id") Long id){
        operadorService.removeById(id);
        return ResponseEntity.noContent().build();
    }

//    @DeleteMapping(value = "/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public ResponseEntity<Object> removerOperador(@PathVariable("id") Long id){
//        operadorService.removeById(id);
//        return ResponseEntity.noContent().build();
//    }
}
