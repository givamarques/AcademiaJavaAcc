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

    public Operador(String matricula, String nomeCompleto, String operacao, String telefone, Supervisor supervisorOperador, String cpf) {
        super(matricula, nomeCompleto, operacao, telefone);
        this.supervisorOperador = supervisorOperador;
        this.cpf = cpf;
    }
}
