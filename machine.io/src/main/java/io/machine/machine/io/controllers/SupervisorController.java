package io.machine.machine.io.controllers;

import io.machine.machine.io.models.Operador;
import io.machine.machine.io.models.Supervisor;
import io.machine.machine.io.services.SupervisorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/supervisor")
public class SupervisorController {

    @Autowired
    private SupervisorService supervisorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Supervisor salvar(@RequestBody Supervisor supervisor){
        return supervisorService.save(supervisor);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Supervisor> operadorList(){
        return supervisorService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Supervisor operadorPorId(@PathVariable("id") Long id){
        return supervisorService.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> removerOperador(@PathVariable("id") Long id){
        supervisorService.removeById(id);
        return ResponseEntity.noContent().build();
    }

//    @DeleteMapping(value = "/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public ResponseEntity<Object> removerSupervisor(@PathVariable("id") Long id){
//        supervisorService.removeById(id);
//        return ResponseEntity.noContent().build();
//    }
}
