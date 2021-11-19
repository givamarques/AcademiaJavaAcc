package io.machine.machine.io.repositories;

import io.machine.machine.io.models.Operador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperadorRepository extends CrudRepository<Operador, Long> {
}
