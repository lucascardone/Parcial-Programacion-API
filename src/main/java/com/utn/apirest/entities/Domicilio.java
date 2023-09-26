package com.utn.apirest.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

/**
 * Clase de entidad que representa información de domicilio en la base de datos.
 */
@Entity
@Table(name = "domicilio")

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
public class Domicilio extends Base {
    /**
     * Nombre de la calle en el domicilio.
     */
    @Column(name = "calle")
    private String calle;

    /**
     * Número en la dirección del domicilio.
     */
    @Column(name = "numero")
    private String numero;

    /**
     * Establecer una relación Many-to-One con la entidad Localidad.
     */
    @ManyToOne(optional = false)

    /**
     * Especificar la columna de unión en la base de datos como "fk_localidad".
     */
    @JoinColumn(name = "fk_localidad")
    private Localidad localidad;
}
