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

    @Id
    @NotNull
    @Column(name = "idOperador")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOperador;

    @NotNull
    @Column(name = "cpf",unique = true, length = 11)
    private String cpf;

}
