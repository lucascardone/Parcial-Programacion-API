package com.utn.apirest.controllers;

import com.utn.apirest.entities.Autor;
import com.utn.apirest.services.AutorImplService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Anotar la clase como un controlador REST para manejar operaciones relacionadas con autores.
@RestController

// Permitir solicitudes CORS desde cualquier origen (*), lo que permite el acceso a este controlador desde múltiples dominios.
@CrossOrigin(origins = "*")

// Especificar la ruta base para las solicitudes HTTP gestionadas por este controlador, que comienza con "api/v1/autores".
@RequestMapping(path = "api/v1/autores")
public class AutorController extends BaseControllerImpl<Autor, AutorImplService> {
}
