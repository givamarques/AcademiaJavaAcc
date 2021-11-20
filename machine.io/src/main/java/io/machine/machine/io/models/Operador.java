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

    @OneToOne(mappedBy = "operador")
    @JoinColumn(name = "idMaquina", referencedColumnName = "id")
    private Maquina maquina;

    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    private Supervisor supervisorOperador;
//------------------------------------------------------------

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOperador;

    @Column(name = "cpf",unique = true, length = 11)
    private String cpf;

//-----------------------------------------------------------

    public Operador(String matricula, String nomeCompleto, String operacao, String telefone, Maquina maquina, Supervisor supervisorOperador, String cpf) {
        super(matricula, nomeCompleto, operacao, telefone);
        this.maquina = maquina;
        this.supervisorOperador = supervisorOperador;
        this.cpf = cpf;
    }
}
