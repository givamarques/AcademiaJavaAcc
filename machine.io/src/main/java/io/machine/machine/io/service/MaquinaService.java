package io.machine.machine.io.service;

import java.util.List;
import java.util.Optional;

import io.machine.machine.io.model.Maquina;
import io.machine.machine.io.repository.MaquinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaquinaService {

    @Autowired
    private MaquinaRepository maquinaRepository;

    public List<Maquina> findAll() {
        return maquinaRepository.findAll();
    }

    public Optional<Maquina> buscarById(Long id){
        return maquinaRepository.findById(id);
    }

    public Maquina save(Maquina maquina){
        return maquinaRepository.save(maquina);
    }

    public void removeById(Long id){
        maquinaRepository.deleteById(id);
    }




}
