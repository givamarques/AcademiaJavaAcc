package io.machine.machine.io.services;

import io.machine.machine.io.customExceptions.ResourceNotFoundException;
import io.machine.machine.io.models.Chamado;
import io.machine.machine.io.models.Maquina;
import io.machine.machine.io.repositories.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository chamadoRepository;

    public List<Chamado> findAll() {
        return (List<Chamado>) chamadoRepository.findAll();
    }

    public Chamado findById(Long id){
        Optional<Chamado> obj = chamadoRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Chamado save(Chamado chamado){
        return chamadoRepository.save(chamado);
    }

    public void removeById(Long id){
        try{
            chamadoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        } catch (RuntimeException e){
            e.printStackTrace();
        }
    }

//    public Maquina update(Long id, Maquina obj){
//        Maquina entity = maquinaRepository.getById(id);
//        updateData(entity, obj);
//        return maquinaRepository.save(entity);
//    }
//
//    private void updateData(Maquina entity, Maquina obj) {
//        entity.setAnydesk(obj.getAnydesk());
//        entity.setAtivo(obj.getAtivo());
//        entity.setModelo(obj.getModelo());
//        entity.setStatus(obj.getStatus());
//    }


}
