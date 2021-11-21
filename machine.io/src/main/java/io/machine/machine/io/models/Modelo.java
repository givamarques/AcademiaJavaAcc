package io.machine.machine.io.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Modelo {

    @OneToMany(mappedBy = "modelo")
    private List<Maquina> maquina;

//    -----------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "modelo", length = 60)
    private String modelo;

//    -----------------------------------------------------

    public Modelo(String modelo) {
        this.modelo = modelo;
    }
}
