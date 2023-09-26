package com.utn.apirest.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Clase base que sirve como superclase mapeada (MappedSuperclass) en el contexto de la persistencia.
 * Esta anotación indica que esta clase es una superclase mapeada y no se mapeará directamente a una tabla en la base de datos.
 * En cambio, sus campos y anotaciones se heredarán por las clases que extiendan esta superclase.
 */
@MappedSuperclass

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

public class Base implements Serializable {
    /**
     * Identificador único de la entidad.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
