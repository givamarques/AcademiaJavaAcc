package io.machine.machine.io.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "maquina")
public class Maquina {

    @Id
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "ativo", unique = true)
    private String ativo;

    @NotNull
    @Column(name = "modelo")
    private String modelo;

    @NotNull
    @Column(name = "anydesk", unique = true)
    private String anydesk;

    @NotNull
    @Column(name = "status")
    private Boolean status;

    @NotNull
    @Column(name = "dataChegada")
    private Date dataDeChegada;

    @NotNull
    @Column(name = "dataSaida")
    private Date dataDeSaida;

}
