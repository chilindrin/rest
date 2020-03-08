package com.chilin.org.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private Integer modelo;

    @Column
    private Integer cantidadruedas;

}
