package mx.unam.fi.melo.application.service.usuario;

import mx.unam.fi.domain.model.Usuario;
import mx.unam.fi.melo.application.service.usuario.dto.ActualizarUsuarioDto;
import mx.unam.fi.melo.application.service.usuario.exception.UsuarioNoEncontradoException;

@FunctionalInterface
public interface ActualizarUsuario {

    Usuario actualizar(Long id, ActualizarUsuarioDto usuario) throws UsuarioNoEncontradoException;

}
