package io.machine.machine.io.controller;

import io.machine.machine.io.model.Operador;
import io.machine.machine.io.model.Supervisor;
import io.machine.machine.io.service.SupervisorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/supervisor")
public class SupervisorController {

    @Autowired
    private SupervisorService supervisorService;
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Supervisor salvar(@RequestBody Supervisor supervisor){
        return supervisorService.save(supervisor);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Supervisor> SupervisorList(){
        return supervisorService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Supervisor SupervisorById(@PathVariable("id") Long id){
        return supervisorService.buscarById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Supervisor não encontrada"));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerSupervisor(@PathVariable("id") Long id){
        supervisorService.buscarById(id)
                .map(supervisor -> {
                    supervisorService.removeById(supervisor.getIdSupervisor());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Maquina não encontrada"));
    }
}
