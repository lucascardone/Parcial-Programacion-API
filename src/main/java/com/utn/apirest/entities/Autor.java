package com.utn.apirest.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

/**
 * Clase de entidad que representa un autor en la base de datos.
 */
@Entity
@Table(name = "autor")

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
public class Autor extends Base {
    /**
     * Nombre del autor.
     */
    @Column(name = "nombre")
    private String nombre;

    /**
     * Apellido del autor.
     */
    @Column(name = "apellido")
    private String apellido;

    /**
     * Biografía del autor con una longitud máxima de 1500 caracteres.
     */
    @Column(name = "biografia", length = 1500)
    private String biografia;
}
