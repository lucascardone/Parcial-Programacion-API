package com.utn.apirest.controllers;

import com.utn.apirest.entities.Persona;
import com.utn.apirest.services.PersonaImplService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para la gestión de entidades relacionadas con personas.
 */
@RestController

/**
 * Permite solicitudes CORS desde cualquier origen (*),
 * lo que facilita el acceso a este controlador desde múltiples dominios.
 */
@CrossOrigin(origins = "*")

/**
 * Define la ruta base para las solicitudes HTTP gestionadas por este controlador,
 * que comienza con "api/v1/personas".
 */
@RequestMapping(path = "api/v1/personas")
public class PersonaController extends BaseControllerImpl<Persona, PersonaImplService> {

    /**
     * Define un endpoint para buscar personas por un filtro.
     *
     * @param filtro Filtro de búsqueda proporcionado como parámetro de consulta.
     * @return ResponseEntity que contiene la lista de personas que coinciden con el filtro o un mensaje de error si no se encuentran.
     */
    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filtro) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"Error\": \"" + e.getMessage() + "\"}"));
        }
    }

    /**
     * Define un endpoint para buscar personas por un filtro con paginación.
     *
     * @param filtro   Filtro de búsqueda proporcionado como parámetro de consulta.
     * @param pageable Información de paginación y ordenamiento.
     * @return ResponseEntity que contiene la lista paginada de personas que coinciden con el filtro o un mensaje de error si no se encuentran.
     */
    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam String filtro, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"Error\": \"" + e.getMessage() + "\"}"));
        }
    }
}
