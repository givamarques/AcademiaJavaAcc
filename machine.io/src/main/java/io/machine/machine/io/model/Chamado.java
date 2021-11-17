package io.machine.machine.io.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "chamado")
public class Chamado {

    @Id
    @NotNull
    @Column(name = "IdChamado", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dataDeAberturaChamado")
    private Instant dataDeAberturaChamado;

    @NotNull
    @Column(name = "dataDeFechamentoChamado")
    private Instant dataDeFechamentoChamado;


}
