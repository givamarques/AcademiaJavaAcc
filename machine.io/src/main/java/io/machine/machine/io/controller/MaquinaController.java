package io.machine.machine.io.controller;


import io.machine.machine.io.model.Maquina;
import io.machine.machine.io.service.MaquinaService;
import io.machine.machine.io.service.OperadorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/maquinas")
public class MaquinaController {

    @Autowired
    private MaquinaService maquinaService;

    private ModelMapper modelMapper;

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
        return maquinaService.buscarById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Maquina não encontrada"));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerMaquina(@PathVariable("id") Long id){
        maquinaService.buscarById(id)
                .map(maquina -> {
                    maquinaService.removeById(maquina.getIdMaquina());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Maquina não encontrada"));
    }
//    @PutMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void atualizarMaquina(@PathVariable("id") Long id, Maquina maquina){
//        maquinaService.buscarById(id)
//                .map(maquinaBase -> {
//                    modelMapper.map(maquina, maquinaBase);
//                    return Void.TYPE;
//                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Maquina não encontrada"));;
//    }
}
