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
    private Long idMaquina;

    @NotNull
//    DTA123456JBTNET
    @Column(name = "ativo", unique = true, length = 15)
    private String ativo;

    @NotNull
    @Column(name = "modelo", length = 50)
    private String modelo;

    @NotNull
//    123456789
    @Column(name = "anydesk", unique = true, length = 9)
    private String anydesk;

    @NotNull
    @Column(name = "status")
    private Boolean status;

}
