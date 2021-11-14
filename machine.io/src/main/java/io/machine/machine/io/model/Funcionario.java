package io.machine.machine.io.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;


@MappedSuperclass
public abstract class Funcionario implements Serializable {

    @Id
    @NotNull
    @Column(name = "idFuncionario", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFuncionario;

    @NotNull
    @Column(name = "matricula", unique = true)
    private String matricula;

    @NotNull
    @Column(name = "nomeCompleto")
    private String nomeCompleto;

    @NotNull
    @Column(name = "operacao")
    private String operacao;

    @NotNull
    @Column(name = "telefone")
    private String telefone;

    public Funcionario() {
    }

    public Funcionario(Long idFuncionario, String matricula, String nomeCompleto, String operacao, String telefone) {
        this.idFuncionario = idFuncionario;
        this.matricula = matricula;
        this.nomeCompleto = nomeCompleto;
        this.operacao = operacao;
        this.telefone = telefone;
    }

    public Long getId() {
        return idFuncionario;
    }

    public void setId(Long id) {
        this.idFuncionario = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
