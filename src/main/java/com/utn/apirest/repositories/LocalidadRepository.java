package com.utn.apirest.repositories;

import com.utn.apirest.entities.Localidad;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de datos para la entidad Localidad.
 *
 * Esta interfaz extiende 'BaseRepository', que a su vez extiende 'JpaRepository', lo que significa que
 * 'LocalidadRepository' hereda automáticamente los métodos CRUD y otras funcionalidades proporcionadas por Spring Data JPA.
 *
 * Los parámetros genéricos '<Localidad, Long>' indican que esta interfaz está específicamente destinada a la entidad 'Localidad'
 * y utiliza un tipo 'Long' como identificador de entidad.
 */
@Repository
public interface LocalidadRepository extends BaseRepository<Localidad, Long> {
}
