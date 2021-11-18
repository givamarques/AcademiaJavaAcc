package io.machine.machine.io.services;

import java.util.List;
import java.util.Optional;

import io.machine.machine.io.models.Maquina;
import io.machine.machine.io.repositories.MaquinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaquinaService {

    @Autowired
    private MaquinaRepository maquinaRepository;

    public List<Maquina> findAll() {
        return maquinaRepository.findAll();
    }

    public Optional<Maquina> findById(Long id){
        return maquinaRepository.findById(id);
    }

    public Maquina save(Maquina maquina){
        return maquinaRepository.save(maquina);
    }

    public void removeById(Long id){
        maquinaRepository.deleteById(id);
    }




}
