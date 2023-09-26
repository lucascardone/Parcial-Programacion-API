package com.utn.apirest.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

/**
 * Clase de entidad que representa información de localidades en la base de datos.
 */
@Entity
@Table(name = "localidad")

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
public class Localidad extends Base {
    /**
     * Denominación o nombre de la localidad.
     */
    @Column(name = "denominacion")
    private String denominacion;
}
