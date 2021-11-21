package io.machine.machine.io.controllers;


import io.machine.machine.io.models.Chamado;
import io.machine.machine.io.models.Modelo;
import io.machine.machine.io.services.ChamadoService;
import io.machine.machine.io.services.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/modelo")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Modelo salvarModelo(@RequestBody Modelo modelo){
        return modeloService.save(modelo);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Modelo> listarModelos(){
        return modeloService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Modelo ModeloPorId(@PathVariable("id") Long id){
        return modeloService.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> removerModeloPorId(@PathVariable("id") Long id){
        modeloService.removeById(id);
        return ResponseEntity.noContent().build();
    }
    
//    @PutMapping(value = "/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public ResponseEntity<Maquina> update(@PathVariable("id") Long id, @RequestBody Maquina obj){
//        obj = maquinaService.update(id, obj);
//        return ResponseEntity.ok().body(obj);
//    }
}
