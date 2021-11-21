package io.machine.machine.io.repositories;

import io.machine.machine.io.models.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ChamadoRepository extends JpaRepository<Chamado, Long> {

}
