package com.utn.apirest.repositories;

import com.utn.apirest.entities.Autor;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de datos para la entidad Autor.
 *
 * Esta interfaz extiende 'BaseRepository', que a su vez extiende 'JpaRepository', lo que significa que
 * 'AutorRepository' hereda automáticamente los métodos CRUD y otras funcionalidades proporcionadas por Spring Data JPA.
 *
 * Los parámetros genéricos '<Autor, Long>' indican que esta interfaz está específicamente destinada a la entidad 'Autor'
 * y utiliza un tipo 'Long' como identificador de entidad.
 */
@Repository
public interface AutorRepository extends BaseRepository<Autor, Long> {
}
