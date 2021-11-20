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

    @OneToOne(mappedBy = "chamado")
    @JoinColumn(name = "idMaquina", referencedColumnName = "id")
    private Maquina maquina;
    //------------------------------------------------------------

    @Id
    @Column(name = "Id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChamado;

    @Column(name = "dataDeAberturaChamado")
    private Instant dataDeAberturaChamado;

    @NotNull
    @Column(name = "dataDeFechamentoChamado")
    private Instant dataDeFechamentoChamado;
    //------------------------------------------------------------

    public Chamado(Supervisor supervisorChamado, Maquina maquina, Instant dataDeAberturaChamado, Instant dataDeFechamentoChamado) {
        this.supervisorChamado = supervisorChamado;
        this.maquina = maquina;
        this.dataDeAberturaChamado = dataDeAberturaChamado;
        this.dataDeFechamentoChamado = dataDeFechamentoChamado;
    }

    public Chamado(Maquina maquina, Instant dataDeAberturaChamado, Instant dataDeFechamentoChamado) {
        this.maquina = maquina;
        this.dataDeAberturaChamado = dataDeAberturaChamado;
        this.dataDeFechamentoChamado = dataDeFechamentoChamado;
    }

    public Chamado(Supervisor supervisorChamado, Instant dataDeAberturaChamado, Instant dataDeFechamentoChamado) {
        this.supervisorChamado = supervisorChamado;
        this.dataDeAberturaChamado = dataDeAberturaChamado;
        this.dataDeFechamentoChamado = dataDeFechamentoChamado;
    }
}
