package com.utn.apirest.controllers;

import com.utn.apirest.entities.Base;
import com.utn.apirest.services.BaseImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Clase abstracta que implementa la interfaz BaseController para proporcionar operaciones CRUD comunes.
 *
 * @param <E> Tipo de entidad que extiende la clase Base.
 * @param <S> Tipo del servicio que gestionará las operaciones CRUD en la entidad.
 */
public abstract class BaseControllerImpl<E extends Base, S extends BaseImplService<E, Long>> implements BaseController<E, Long> {

    // Inyectar una instancia del servicio que gestionará las operaciones CRUD en la entidad.
    @Autowired
    protected S servicio;

    /**
     * Obtiene todas las entidades.
     *
     * @return ResponseEntity que contiene una lista de todas las entidades o un mensaje de error si no se encuentran.
     */
    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Error, por favor intente más tarde.\"}");
        }
    }

    /**
     * Obtiene todas las entidades de manera paginada.
     *
     * @param pageable Información de paginación y ordenamiento.
     * @return ResponseEntity que contiene una lista paginada de entidades o un mensaje de error si no se encuentran.
     */
    @GetMapping("/paged")
    public ResponseEntity<?> getAll(Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll(pageable));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Error, por favor intente más tarde.\"}");
        }
    }

    /**
     * Obtiene una entidad por su identificador.
     *
     * @param id Identificador único de la entidad.
     * @return ResponseEntity que contiene la entidad encontrada o un mensaje de error si no se encuentra.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findById(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Error, por favor intente más tarde.\"}");
        }
    }

    /**
     * Guarda una nueva entidad.
     *
     * @param entity La entidad a ser guardada.
     * @return ResponseEntity que indica si la entidad se guardó exitosamente o si hubo un error.
     */
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody E entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.save(entity));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":\"Error, por favor intente más tarde.\"}");
        }
    }

    /**
     * Actualiza una entidad existente por su identificador.
     *
     * @param id     Identificador único de la entidad a ser actualizada.
     * @param entity La entidad con los cambios a ser aplicados.
     * @return ResponseEntity que indica si la entidad se actualizó exitosamente o si hubo un error.
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody E entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.update(id, entity));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":\"Error, por favor intente más tarde.\"}");
        }
    }

    /**
     * Elimina una entidad por su identificador.
     *
     * @param id Identificador único de la entidad a ser eliminada.
     * @return ResponseEntity que indica si la entidad se eliminó exitosamente o si hubo un error.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(servicio.delete(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":\"Error, por favor intente más tarde.\"}");
        }
    }
}
