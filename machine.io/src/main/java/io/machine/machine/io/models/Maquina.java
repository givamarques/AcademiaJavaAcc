package io.machine.machine.io.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Maquina implements Serializable {
    private static final long serialVersionUID = 1L;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idChamado", referencedColumnName = "id")
    private Chamado chamado;

    @ManyToOne(cascade = CascadeType.ALL)
    private Modelo modelo;

    //------------------------------------------------------------

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMaquina;

//    DTA123456JBTNET
    @Column(name = "ativo", unique = true, length = 15)
    private String ativo;

//    123 456 789
    @Column(name = "anydesk", unique = true, length = 11)
    private String anydesk;

    @Column(name = "status")
    private Boolean status;

    //------------------------------------------------------------

    public Maquina(Modelo modelo, String ativo, String anydesk, Boolean status) {
        this.modelo = modelo;
        this.ativo = ativo;
        this.anydesk = anydesk;
        this.status = status;
    }
}
