package com.utn.apirest.controllers;

import com.utn.apirest.entities.Base;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

/**
 * Interfaz genérica que define métodos comunes para controladores que gestionan entidades que extienden la clase Base.
 *
 * @param <E>  Tipo de entidad que extiende la clase Base.
 * @param <ID> Tipo de identificador serializable asociado a la entidad.
 */
public interface BaseController<E extends Base, ID extends Serializable> {

    /**
     * Obtiene todas las entidades de manera paginada.
     *
     * @return ResponseEntity que contiene una lista paginada de entidades.
     */
    public ResponseEntity<?> getAll();

    /**
     * Obtiene todas las entidades de manera paginada.
     *
     * @param pageable Información de paginación y ordenamiento.
     * @return ResponseEntity que contiene una lista paginada de entidades.
     */
    public ResponseEntity<?> getAll(Pageable pageable);

    /**
     * Obtiene una entidad por su identificador.
     *
     * @param id Identificador único de la entidad.
     * @return ResponseEntity que contiene la entidad encontrada o un mensaje de error si no se encuentra.
     */
    public ResponseEntity<?> getOne(@PathVariable ID id);

    /**
     * Guarda una nueva entidad.
     *
     * @param entity La entidad a ser guardada.
     * @return ResponseEntity que indica si la entidad se guardó exitosamente o si hubo un error.
     */
    public ResponseEntity<?> save(@RequestBody E entity);

    /**
     * Actualiza una entidad existente por su identificador.
     *
     * @param id     Identificador único de la entidad a ser actualizada.
     * @param entity La entidad con los cambios a ser aplicados.
     * @return ResponseEntity que indica si la entidad se actualizó exitosamente o si hubo un error.
     */
    public ResponseEntity<?> update(@PathVariable ID id, @RequestBody E entity);

    /**
     * Elimina una entidad por su identificador.
     *
     * @param id Identificador único de la entidad a ser eliminada.
     * @return ResponseEntity que indica si la entidad se eliminó exitosamente o si hubo un error.
     */
    public ResponseEntity<?> delete(@PathVariable ID id);
}
