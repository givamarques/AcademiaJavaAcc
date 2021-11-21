package io.machine.machine.io.repositories;

import io.machine.machine.io.models.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SupervisorRepository extends JpaRepository<Supervisor, Long> {
}
