package io.machine.machine.io.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "supervisor")
@PrimaryKeyJoinColumn(name="idFuncionario")
public class Supervisor extends Funcionario {

    @OneToMany(mappedBy = "supervisorChamado")
    private List<Chamado> chamadoList;

    @OneToMany(mappedBy = "supervisorOperador")
    private List<Operador> operadorList;


    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSupervisor;

    @NotNull
    @Column(name = "ramal" ,unique = false, length = 6)
    private String ramal;

    public Supervisor(String matricula, String nomeCompleto, String operacao, String telefone, String ramal) {
        super(matricula, nomeCompleto, operacao, telefone);
        this.ramal = ramal;
    }
}
