package com.utn.apirest.controllers;

import com.utn.apirest.entities.Localidad;
import com.utn.apirest.services.LocalidadImplService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador REST para la gestión de entidades relacionadas con las localidades.
 */
@RestController

/**
 * Permite solicitudes CORS desde cualquier origen (*),
 * lo que facilita el acceso a este controlador desde múltiples dominios.
 */
@CrossOrigin(origins = "*")

/**
 * Define la ruta base para las solicitudes HTTP gestionadas por este controlador,
 * que comienza con "api/v1/localidades".
 */
@RequestMapping(path = "api/v1/localidades")
public class LocalidadController extends BaseControllerImpl<Localidad, LocalidadImplService> {
}