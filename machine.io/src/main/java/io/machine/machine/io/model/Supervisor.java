package io.machine.machine.io.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "supervisor")
@PrimaryKeyJoinColumn(name="idFuncionario")
public class Supervisor extends Funcionario {

    @NotNull
    @Column(name = "ramal" ,unique = false)
    private String ramal;

    public Supervisor() {

    }

    public Supervisor(String ramal) {
        this.ramal = ramal;
    }

    public Supervisor(Long idSupervisor, String matricula, String nomeCompleto, String operacao, String telefone, String ramal) {
        super(idSupervisor, matricula, nomeCompleto, operacao, telefone);
        this.ramal = ramal;
    }

    public String getRamal() {
        return ramal;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }
}
