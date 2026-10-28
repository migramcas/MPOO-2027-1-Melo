package mx.unam.fi.melo.application.service.usuario;

import mx.unam.fi.domain.model.Usuario;
import mx.unam.fi.melo.application.service.usuario.dto.NuevoUsuarioDto;

@FunctionalInterface
public interface CrearUsuario {

    Usuario crear(NuevoUsuarioDto usuario);
}
