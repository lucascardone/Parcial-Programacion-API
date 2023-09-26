package com.utn.apirest.services;

import com.utn.apirest.entities.Localidad;

/**
 * Interfaz que extiende 'BaseService' y se especializa en operaciones CRUD para la entidad 'Localidad'.
 *
 * Esta interfaz hereda automáticamente los métodos CRUD declarados en 'BaseService' para operaciones en la entidad 'Localidad'.
 */
public interface LocalidadService extends BaseService<Localidad, Long> {
    /*
        Los parámetros genéricos '<Localidad, Long>' indican que esta interfaz está específicamente destinada a la entidad 'Localidad'
        y utiliza un tipo 'Long' como identificador de entidad.
    */
}
