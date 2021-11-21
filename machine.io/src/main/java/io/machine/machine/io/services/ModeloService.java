package io.machine.machine.io.services;

import io.machine.machine.io.customExceptions.ResourceNotFoundException;
import io.machine.machine.io.models.Chamado;
import io.machine.machine.io.models.Maquina;
import io.machine.machine.io.models.Modelo;
import io.machine.machine.io.repositories.ChamadoRepository;
import io.machine.machine.io.repositories.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    public List<Modelo> findAll() {
        return (List<Modelo>) modeloRepository.findAll();
    }

    public Modelo findById(Long id){
        Optional<Modelo> obj = modeloRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Modelo save(Modelo modelo){
        return modeloRepository.save(modelo);
    }

    public void removeById(Long id){
        try{
            modeloRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        } catch (RuntimeException e){
            e.printStackTrace();
        }
    }

    public Modelo update(Long id, Modelo obj){
        Modelo entity = modeloRepository.getById(id);
        updateData(entity, obj);
        return modeloRepository.save(entity);
    }

    private void updateData(Modelo entity, Modelo obj) {
        entity.setModelo(obj.getModelo());
    }


}
