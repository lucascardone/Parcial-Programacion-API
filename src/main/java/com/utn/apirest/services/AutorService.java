package com.utn.apirest.services;

import com.utn.apirest.entities.Autor;

/**
 * Interfaz del servicio para la entidad Autor que extiende BaseService.
 *
 * Esta interfaz hereda automáticamente los métodos CRUD declarados en 'BaseService' para operaciones en la entidad 'Autor'.
 * Los parámetros genéricos '<Autor, Long>' indican que esta interfaz está específicamente destinada a la entidad 'Autor' y
 * utiliza un tipo 'Long' como identificador de entidad.
 */
public interface AutorService extends BaseService<Autor, Long> {
}
