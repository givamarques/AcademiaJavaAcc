package io.machine.machine.io.models;

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

    @ManyToOne
    @JoinColumn(name = "idSupervisor")
    private Supervisor supervisorChamado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idMaquina", referencedColumnName = "id")
    private Maquina maquina;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idOperadr", referencedColumnName = "id")
    private Operador operador;

    @Id
    @Column(name = "Id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChamado;

    @Column(name = "dataDeAberturaChamado")
    private Instant dataDeAberturaChamado;

    @NotNull
    @Column(name = "dataDeFechamentoChamado")
    private Instant dataDeFechamentoChamado;


}
