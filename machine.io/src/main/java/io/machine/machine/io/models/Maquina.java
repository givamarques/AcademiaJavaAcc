package io.machine.machine.io.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "maquina")
public class Maquina implements Serializable {
    private static final long serialVersionUID = 1L;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idChamado", referencedColumnName = "id")
    private Chamado chamado;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMaquina;

//    DTA123456JBTNET
    @Column(name = "ativo", unique = true, length = 15)
    private String ativo;

    @Column(name = "modelo", length = 50)
    private String modelo;

//    123456789
    @Column(name = "anydesk", unique = true, length = 9)
    private String anydesk;

    @Column(name = "status")
    private Boolean status;

}
