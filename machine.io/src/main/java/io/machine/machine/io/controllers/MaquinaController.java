package io.machine.machine.io.controllers;


import io.machine.machine.io.models.Maquina;
import io.machine.machine.io.services.MaquinaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/maquinas")
public class MaquinaController {

    @Autowired
    private MaquinaService maquinaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Maquina salvar(@RequestBody Maquina maquina){
        return maquinaService.save(maquina);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Maquina> MaquinaList(){
        return maquinaService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Maquina maquinaPorId(@PathVariable("id") Long id){
        return maquinaService.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> removerMaquina(@PathVariable("id") Long id){
        maquinaService.removeById(id);
        return ResponseEntity.noContent().build();
    }
    
//    @PutMapping(value = "/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public ResponseEntity<Maquina> update(@PathVariable("id") Long id, @RequestBody Maquina obj){
//        obj = maquinaService.update(id, obj);
//        return ResponseEntity.ok().body(obj);
//    }
}
