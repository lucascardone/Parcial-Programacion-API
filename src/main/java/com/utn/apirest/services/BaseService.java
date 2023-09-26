package com.utn.apirest.services;

import com.utn.apirest.entities.Base;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

/**
 * Interfaz que define los métodos básicos para operaciones CRUD en entidades.
 *
 * Esta interfaz declara los métodos comunes necesarios para realizar operaciones CRUD en entidades.
 */
public interface BaseService<E extends Base, ID extends Serializable> {
    /**
     * Recupera todas las entidades de la base de datos.
     *
     * @return Lista de entidades.
     * @throws Exception si ocurre un error durante la operación.
     */
    public List<E> findAll() throws Exception;

    /**
     * Recupera todas las entidades de la base de datos con paginación.
     *
     * @param pageable Objeto Pageable para la paginación.
     * @return Página de entidades.
     * @throws Exception si ocurre un error durante la operación.
     */
    public Page<E> findAll(Pageable pageable) throws Exception;

    /**
     * Recupera una entidad por su identificador único.
     *
     * @param id Identificador único de la entidad.
     * @return La entidad encontrada o null si no se encuentra.
     * @throws Exception si ocurre un error durante la operación.
     */
    public E findById(ID id) throws Exception;

    /**
     * Guarda una nueva entidad en la base de datos.
     *
     * @param entity La entidad a ser guardada.
     * @return La entidad guardada.
     * @throws Exception si ocurre un error durante la operación.
     */
    public E save(E entity) throws Exception;

    /**
     * Actualiza una entidad existente en la base de datos.
     *
     * @param id Identificador único de la entidad a ser actualizada.
     * @param entity La entidad con los cambios a ser actualizados.
     * @return La entidad actualizada.
     * @throws Exception si ocurre un error durante la operación.
     */
    public E update(ID id, E entity) throws Exception;

    /**
     * Elimina una entidad de la base de datos por su identificador único.
     *
     * @param id Identificador único de la entidad a ser eliminada.
     * @return True si la entidad fue eliminada con éxito, false si no se encontró la entidad.
     * @throws Exception si ocurre un error durante la operación.
     */
    public boolean delete(ID id) throws Exception;
}
