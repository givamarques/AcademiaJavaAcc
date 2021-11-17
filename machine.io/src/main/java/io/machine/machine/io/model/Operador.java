package io.machine.machine.io.model;

import com.sun.istack.NotNull;
import io.machine.machine.io.model.Funcionario;
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

    @Id
    @NotNull
    @Column(name = "idOperador", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOperador;

    @NotNull
    @Column(name = "cpf",unique = true, length = 11)
    private String cpf;

}
