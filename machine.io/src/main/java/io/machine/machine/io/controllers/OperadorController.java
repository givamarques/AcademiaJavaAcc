package io.machine.machine.io.controllers;

import io.machine.machine.io.models.Operador;
import io.machine.machine.io.services.OperadorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/operador")
public class OperadorController {

    @Autowired
    private OperadorService operadorService;
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Operador salvar(@RequestBody Operador operador){
        return operadorService.save(operador);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Operador> MaquinaList(){
        return operadorService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Operador operadorPorId(@PathVariable("id") Long id){
        return operadorService.buscarById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Maquina não encontrada"));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerOperador(@PathVariable("id") Long id){
        operadorService.buscarById(id)
                .map(operador -> {
                    operadorService.removeById(operador.getIdOperador());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Maquina não encontrada"));
    }
}
