package com.chillin.co.entity;

import javax.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="nombre", length=50, nullable=false)
    private String nombre;

    @Column(name="apellido", length=50, nullable=false)
    private String apellido;

    @Column(name="modelo", nullable=false)
    private int modelo;

    @Column(name="cantidadruedas", nullable=false)
    private int cantidadruedas;

}
