package com.utn.apirest.services;

import com.utn.apirest.entities.Persona;
import com.utn.apirest.repositories.BaseRepository;
import com.utn.apirest.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Clase que implementa 'PersonaService' y extiende 'BaseServiceImpl'.
 *
 * Esta clase implementa 'PersonaService' y extiende 'BaseServiceImpl', lo que significa que hereda los métodos CRUD de 'BaseService'
 * para operaciones en la entidad 'Persona'.
 */
@Service
public class PersonaImplService extends BaseImplService<Persona, Long> implements PersonaService {

    @Autowired // Inyección de dependencia de 'PersonaRepository' para acceder a la capa de persistencia.
    private PersonaRepository personaRepository;

    /**
     * Constructor que recibe un 'BaseRepository' como parámetro y lo pasa al constructor de la clase base 'BaseServiceImpl'.
     */
    public PersonaImplService(BaseRepository<Persona, Long> baseRepository) {
        super(baseRepository);
    }

    /**
     * Implementación del método de búsqueda de personas por filtro definido en 'PersonaService'.
     *
     * @param filtro El filtro de búsqueda.
     * @return Lista de personas que coinciden con el filtro.
     * @throws Exception si ocurre un error durante la operación.
     */
    @Override
    public List<Persona> search(String filtro) throws Exception {
        try {
            // Realizar una búsqueda de personas que contengan el filtro en el nombre o apellido.
            List<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);
            // List<Persona> personas = personaRepository.search(filtro);
            // List<Persona> personas = personaRepository.searchNativo(filtro);
            return personas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Implementación del método de búsqueda paginada de personas por filtro definido en 'PersonaService'.
     *
     * @param filtro El filtro de búsqueda.
     * @param pageable Objeto Pageable para la paginación.
     * @return Página de personas que coinciden con el filtro.
     * @throws Exception si ocurre un error durante la operación.
     */
    @Override
    public Page<Persona> search(String filtro, Pageable pageable) throws Exception {
        try {
            // Realizar una búsqueda paginada de personas que contengan el filtro en el nombre o apellido.
            Page<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro, pageable);
            // Page<Persona> personas = personaRepository.search(filtro, pageable);
            // Page<Persona> personas = personaRepository.searchNativo(filtro, pageable);
            return personas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
