package io.machine.machine.io.model;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;


@Entity
@Table(name = "chamado")
public class Chamado {

    @Id
    @NotNull
    @Column(name = "IdChamado", unique = true)
    private Long id;

    @NotNull
    @Column(name = "dataDeAberturaDoChamado")
    private Instant dataDeAberturaDoChamado;



    public Chamado() {
    }

    public Chamado(Long id, Instant dataDeAberturaDoChamado) {
        this.id = id;
        this.dataDeAberturaDoChamado = dataDeAberturaDoChamado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDataDeAberturaDoChamado() {
        return dataDeAberturaDoChamado;
    }

    public void setDataDeAberturaDoChamado(Instant dataDeAberturaDoChamado) {
        this.dataDeAberturaDoChamado = dataDeAberturaDoChamado;
    }
}
