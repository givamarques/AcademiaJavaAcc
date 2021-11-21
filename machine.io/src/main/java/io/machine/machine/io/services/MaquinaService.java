package io.machine.machine.io.services;

import java.util.List;
import java.util.Optional;

import io.machine.machine.io.customExceptions.ResourceNotFoundException;
import io.machine.machine.io.models.Maquina;
import io.machine.machine.io.repositories.MaquinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class MaquinaService {

    @Autowired
    private MaquinaRepository maquinaRepository;

    public List<Maquina> findAll() {
        return maquinaRepository.findAll();
    }

    public Maquina findById(Long id){
        Optional<Maquina> obj = maquinaRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Maquina save(Maquina maquina){
        return maquinaRepository.save(maquina);
    }

    public void removeById(Long id){
        try{
            maquinaRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        } catch (RuntimeException e){
            e.printStackTrace();
        }
    }

    public Maquina update(Long id, Maquina obj){
        Maquina entity = maquinaRepository.getById(id);
        updateData(entity, obj);
        return maquinaRepository.save(entity);
    }

    private void updateData(Maquina entity, Maquina obj) {
        entity.setAnydesk(obj.getAnydesk());
        entity.setAtivo(obj.getAtivo());
        entity.setModelo(obj.getModelo());
        entity.setStatus(obj.getStatus());
    }


}
