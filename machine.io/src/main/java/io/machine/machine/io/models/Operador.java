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
@Table(name = "operador")
@PrimaryKeyJoinColumn(name="idFuncionario")
public class Operador extends Funcionario {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idChamado", referencedColumnName = "id")
    private Chamado chamado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idMaquina", referencedColumnName = "id")
    private Maquina maquina;

    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    private Supervisor supervisorOperador;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOperador;

    @Column(name = "cpf",unique = true, length = 11)
    private String cpf;

}
