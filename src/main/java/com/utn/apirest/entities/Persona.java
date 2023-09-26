package com.utn.apirest.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase de entidad que representa información de personas en la base de datos.
 */
@Entity
@Table(name = "persona")

/**
 * Anotar la clase con Lombok para generar automáticamente métodos como getters, setters, equals y otros.
 */
@Data

/**
 * Constructor sin argumentos generado automáticamente.
 */
@NoArgsConstructor

/**
 * Constructor con todos los argumentos generado automáticamente.
 */
@AllArgsConstructor

/**
 * Anotar la clase para habilitar la auditoría de cambios utilizando Hibernate Envers.
 */
@Audited
public class Persona extends Base {

    /**
     * Nombre de la persona.
     */
    @Column(name = "nombre")
    private String nombre;

    /**
     * Apellido de la persona.
     */
    @Column(name = "apellido")
    private String apellido;

    /**
     * Número de documento de identidad de la persona.
     */
    @Column(name = "dni")
    private int dni;

    /**
     * Establecer una relación One-to-One con la entidad Domicilio.
     */
    @OneToOne(cascade = CascadeType.ALL)

    /**
     * Especificar la columna de unión en la base de datos como "fk_domicilio".
     */
    @JoinColumn(name = "fk_domicilio")
    private Domicilio domicilio;

    /**
     * Establecer una relación One-to-Many con la entidad Libro.
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)

    /**
     * inverseJoinColumns: Este parámetro se utiliza para especificar las columnas de la tabla de la entidad objetivo (Libro)
     * que se utilizarán para unirse a la tabla de unión. Estas columnas representan la parte de la relación que pertenece a la
     * entidad objetivo.
     */
    @JoinTable(name = "persona_libro",
            joinColumns = @JoinColumn(name = "persona_id"),
            inverseJoinColumns = @JoinColumn(name = "libro_id")
    )
    private List<Libro> libros = new ArrayList<Libro>();
}
