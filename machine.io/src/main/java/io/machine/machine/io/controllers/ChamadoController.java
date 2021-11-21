package io.machine.machine.io.controllers;


import io.machine.machine.io.models.Chamado;
import io.machine.machine.io.models.Maquina;
import io.machine.machine.io.services.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/chamado")
public class ChamadoController {

    @Autowired
    private ChamadoService chamadoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Chamado salvarChamado(@RequestBody Chamado chamado){
        return chamadoService.save(chamado);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Chamado> listarChamados(){
        return chamadoService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Chamado chamadoPorId(@PathVariable("id") Long id){
        return chamadoService.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> removerChamadoPorId(@PathVariable("id") Long id){
        chamadoService.removeById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Chamado> update(@PathVariable("id") Long id, @RequestBody Chamado obj){
        obj = chamadoService.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}
