package com.utn.apirest.repositories;

import com.utn.apirest.entities.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Interfaz base para repositorios de datos.
 *
 * La anotación @NoRepositoryBean indica que no es un repositorio Spring Data JPA en sí, sino una interfaz base que
 * proporciona métodos comunes para otros repositorios.
 *
 * Esta interfaz extiende JpaRepository, que proporciona métodos CRUD genéricos para interactuar con la base de datos.
 *
 * Los parámetros genéricos <E extends Base, ID extends Serializable> indican que esta interfaz es genérica y
 * puede ser utilizada por cualquier entidad que extienda la clase Base y utilice un tipo de identificación
 * serializable como su clave primaria.
 */
@NoRepositoryBean
public interface BaseRepository<E extends Base, ID extends Serializable> extends JpaRepository<E, ID> {
}

