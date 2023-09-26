package com.utn.apirest.services;

import com.utn.apirest.entities.Autor;
import com.utn.apirest.repositories.AutorRepository;
import com.utn.apirest.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementación del servicio para la entidad Autor que extiende BaseServiceImpl.
 *
 * Esta clase implementa 'AutorService' y extiende 'BaseServiceImpl', lo que significa que hereda los métodos CRUD de 'BaseService'
 * para operaciones en la entidad 'Autor'.
 */
@Service
public class AutorImplService extends BaseImplService<Autor, Long> implements AutorService {
    // La clase 'AutorServiceImpl' implementa 'AutorService' y extiende 'BaseServiceImpl', lo que significa que hereda
    // los métodos CRUD de 'BaseService' para operaciones en la entidad 'Autor'.

    @Autowired // Inyección de dependencia de 'AutorRepository' para acceder a la capa de persistencia.
    private AutorRepository autorRepository;

    /**
     * Constructor que recibe un 'BaseRepository' como parámetro y lo pasa al constructor de la clase base 'BaseServiceImpl'.
     */
    public AutorImplService(BaseRepository<Autor, Long> baseRepository) {
        super(baseRepository);
    }
}
