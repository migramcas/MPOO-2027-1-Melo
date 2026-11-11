package mx.unam.fi.melo.application.service.usuario;

import mx.unam.fi.domain.model.Rol;
import mx.unam.fi.melo.application.service.usuario.exception.UsuarioNoEncontradoException;

public interface EliminarUsuario {

    void eliminar(Long id);

    void eliminar(Long id, Rol rolVerificacion) throws UsuarioNoEncontradoException;

}
