package com.utn.apirest.services;

import com.utn.apirest.entities.Base;
import com.utn.apirest.repositories.BaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * Clase base abstracta para servicios que implementan operaciones CRUD genéricas.
 *
 * Esta clase implementa la interfaz 'BaseService' y proporciona métodos comunes para realizar operaciones CRUD en entidades.
 *
 * La anotación @Transactional en Spring se usa para administrar transacciones en aplicaciones Java.
 * Cuando se coloca en un método o clase, inicia una transacción antes de que se ejecute el método anotado.
 * Después de la ejecución, realiza un "commit" si la operación va bien y un "rollback" en caso de una excepción no controlada.
 * Esto garantiza que las operaciones en la base de datos sean atómicas y consistentes.
 */
public abstract class BaseImplService<E extends Base, ID extends Serializable> implements BaseService<E, ID> {

    // Declarar una instancia de 'BaseRepository' para acceder a la capa de persistencia.
    protected BaseRepository<E, ID> baseRepository;

    /**
     * Constructor que recibe un 'BaseRepository' como parámetro.
     */
    public BaseImplService(BaseRepository<E, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    @Transactional
    public List<E> findAll() throws Exception {
        try {
            List<E> entities = baseRepository.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Page<E> findAll(Pageable pageable) throws Exception {
        try {
            Page<E> entities = baseRepository.findAll(pageable);
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E findById(ID id) throws Exception {
        try {
            Optional<E> optionalEntity = baseRepository.findById(id);
            return optionalEntity.orElse(null);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E save(E entity) throws Exception {
        try {
            entity = baseRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E update(ID id, E entity) throws Exception {
        try {
            Optional<E> optionalEntity = baseRepository.findById(id);
            if (optionalEntity.isPresent()) {
                E persona = optionalEntity.get();
                persona = baseRepository.save(entity);
                return persona;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(ID id) throws Exception {
        try {
            if (baseRepository.existsById(id)) {
                baseRepository.deleteById(id);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
