package io.machine.machine.io.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "supervisor")
@PrimaryKeyJoinColumn(name="idFuncionario")
public class Supervisor extends Funcionario {

    @Id
    @NotNull
    @Column(name = "idSupervisor", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSupervisor;

    @NotNull
    @Column(name = "ramal" ,unique = false, length = 6)
    private String ramal;

}
