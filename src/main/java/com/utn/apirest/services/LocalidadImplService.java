package com.utn.apirest.services;

import com.utn.apirest.entities.Localidad;
import com.utn.apirest.repositories.BaseRepository;
import com.utn.apirest.repositories.LocalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase que implementa 'LocalidadService' y extiende 'BaseServiceImpl'.
 *
 * Esta clase implementa 'LocalidadService' y extiende 'BaseServiceImpl', lo que significa que hereda los métodos CRUD de 'BaseService'
 * para operaciones en la entidad 'Localidad'.
 */
@Service
public class LocalidadImplService extends BaseImplService<Localidad, Long> implements LocalidadService {
    // La clase 'LocalidadServiceImpl' implementa 'LocalidadService' y extiende 'BaseServiceImpl', lo que significa que
    // hereda los métodos CRUD de 'BaseService' para operaciones en la entidad 'Localidad'.

    @Autowired // Inyección de dependencia de 'LocalidadRepository' para acceder a la capa de persistencia.
    private LocalidadRepository localidadRepository;

    /**
     * Constructor que recibe un 'BaseRepository' como parámetro y lo pasa al constructor de la clase base 'BaseServiceImpl'.
     */
    public LocalidadImplService(BaseRepository<Localidad, Long> baseRepository) {
        super(baseRepository);
    }
}
