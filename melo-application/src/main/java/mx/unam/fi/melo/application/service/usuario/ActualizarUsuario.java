package mx.unam.fi.melo.application.service.usuario;

import mx.unam.fi.domain.model.Usuario;
import mx.unam.fi.melo.application.service.usuario.dto.ActualizarUsuarioDto;

@FunctionalInterface
public interface ActualizarUsuario {

    Usuario actualizar(Long id, ActualizarUsuarioDto usuario);

}
