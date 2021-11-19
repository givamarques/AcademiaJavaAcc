package io.machine.machine.io.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Funcionario implements Serializable {

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



}
