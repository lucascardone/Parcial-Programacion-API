package com.utn.apirest.repositories;

import com.utn.apirest.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio de datos para la entidad Persona.
 *
 * Esta interfaz extiende 'BaseRepository', que a su vez extiende 'JpaRepository', lo que significa que
 * 'PersonaRepository' hereda automáticamente los métodos CRUD y otras funcionalidades proporcionadas por Spring Data JPA.
 *
 * Los parámetros genéricos '<Persona, Long>' indican que esta interfaz está específicamente destinada a la entidad 'Persona'
 * y utiliza un tipo 'Long' como identificador de entidad.
 */
@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {

    /**
     * Búsqueda por nombre o apellido utilizando Spring Data Query Methods.
     */
    List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);
    Page<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);

    /**
     * Consulta JPQL con parámetros indexados.
     */
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %?1% OR p.apellido LIKE %?1%")
    List<Persona> search(String filtro);
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %?1% OR p.apellido LIKE %?1%")
    Page<Persona> search(String filtro, Pageable pageable);

    /**
     * Consulta JPQL con parámetros nombrados (comentada para evitar conflicto con la consulta nativa).
     */
    /*
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro1%")
    List<Persona> search(@Param("filtro") String filtro);
    */

    /**
     * Consulta nativa utilizando SQL nativo.
     */
    @Query(value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%", nativeQuery = true)
    List<Persona> searchNativo(String filtro);
    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM persona",
            nativeQuery = true
    )
    Page<Persona> searchNativo(String filtro, Pageable pageable);
}
