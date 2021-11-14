package io.machine.machine.io.model;

import com.sun.istack.NotNull;
import io.machine.machine.io.model.Funcionario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="idFuncionario")
public class Operador extends Funcionario {


    @NotNull
    @Column(name = "cpf",unique = true)
    private String cpf;

    public Operador() {
    }

    public Operador(Long idFuncionario, String matricula, String nomeCompleto, String operacao, String telefone) {
        super(idFuncionario, matricula, nomeCompleto, operacao, telefone);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


}
