package com.utn.apirest.services;

import com.utn.apirest.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Interfaz que extiende 'BaseService' y añade métodos específicos de búsqueda para la entidad 'Persona'.
 *
 * Esta interfaz hereda automáticamente los métodos CRUD declarados en 'BaseService' para operaciones en la entidad 'Persona'.
 */
public interface PersonaService extends BaseService<Persona, Long> {
    /*
        Los parámetros genéricos '<Persona, Long>' indican que esta interfaz está específicamente destinada a la entidad 'Persona'
        y utiliza un tipo 'Long' como identificador de entidad.
     */

    /**
     * Método para buscar personas por un filtro.
     *
     * @param filtro El filtro de búsqueda.
     * @return Lista de personas que coinciden con el filtro.
     * @throws Exception si ocurre un error durante la operación.
     */
    List<Persona> search(String filtro) throws Exception;

    /**
     * Método para buscar personas por un filtro con paginación.
     *
     * @param filtro El filtro de búsqueda.
     * @param pageable Objeto Pageable para la paginación.
     * @return Página de personas que coinciden con el filtro.
     * @throws Exception si ocurre un error durante la operación.
     */
    Page<Persona> search(String filtro, Pageable pageable) throws Exception;

    /*
        Diferencia con las interfaces anteriores:
        'PersonaService' agrega métodos específicos de búsqueda que no son parte de 'BaseService' para permitir la
        búsqueda de personas por un filtro y paginada por filtro. Esto hace que 'PersonaService' sea diferente de las
        interfaces anteriores porque introduce funcionalidades adicionales específicas de búsqueda para la entidad 'Persona'.
     */
}
