package com.utn.apirest.config;

import com.utn.apirest.entities.audit.Revision;
import org.hibernate.envers.RevisionListener;

/**
 * En el contexto de Hibernate Envers, un "Revision Listener" es una interfaz o clase que brinda a los desarrolladores la capacidad
 * de personalizar y supervisar el proceso de auditoría de revisiones en una aplicación Java. Cuando una entidad auditada experimenta modificaciones,
 * Hibernate Envers registra automáticamente una revisión para mantener un historial de los cambios realizados.
 */
public class CustomRevisionListener implements RevisionListener {
    /**
     * Este método se llama automáticamente al crear una nueva revisión.
     *
     * @param revisionEntity Objeto que representa la entidad de revisión actual.
     *                       En este caso, se espera que sea una instancia de la clase Revision.
     */
    @Override
    public void newRevision(Object revisionEntity) {
        final Revision revision = (Revision) revisionEntity;
    }
}
