package io.machine.machine.io.repository;

import io.machine.machine.io.model.Operador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperadorRepository extends CrudRepository<Operador, Long> {
}
