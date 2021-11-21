package io.machine.machine.io.models;

import com.sun.istack.NotNull;
import io.machine.machine.io.models.enums.Status;
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


    private Integer status;

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


    public Chamado(Supervisor supervisorChamado, Maquina maquina, Status status, Instant dataDeAberturaChamado) {
        this.supervisorChamado = supervisorChamado;
        this.maquina = maquina;
        setStatus(status);
        this.dataDeAberturaChamado = dataDeAberturaChamado;
    }

    public Status getStatus() {
        return Status.valueOf(status);
    }

    public void setStatus(Status status) {
        if (status != null){
            this.status = status.getCode();
        }
    }
}
