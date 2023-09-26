package com.utn.apirest.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import java.util.List;

/**
 * Clase de entidad que representa información de libros en la base de datos.
 */
@Entity
@Table(name = "libro")

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
public class Libro extends Base{
    /**
     * Título del libro.
     */
    @Column(name = "titulo")
    private String titulo;

    /**
     * Año de publicación del libro.
     */
    @Column(name = "fecha")
    private int fecha;

    /**
     * Género del libro.
     */
    @Column(name = "genero")
    private String genero;

    /**
     * Número de páginas del libro.
     */
    @Column(name = "paginas")
    private int paginas;

    /**
     * Establecer una relación Many-to-Many con la entidad Autor.
     */
    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)

    /**
     * No es necesario especificar una columna de unión aquí, ya que se utilizará la tabla de unión predeterminada.
     */
    private List<Autor> autores;
}
