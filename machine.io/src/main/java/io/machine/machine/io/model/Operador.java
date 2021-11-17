package io.machine.machine.io.model;

import com.sun.istack.NotNull;
import io.machine.machine.io.model.Funcionario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="idFuncionario")
public class Operador extends Funcionario {


    @NotNull
    @Column(name = "cpf",unique = true, length = 11)
    private String cpf;

}
