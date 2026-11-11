package mx.unam.fi.melo.application.service.usuario;

import mx.unam.fi.domain.model.Rol;

public interface EliminarUsuario {

    void eliminar(Long id);

    void eliminar(Long id, Rol rolVerificacion);

}
