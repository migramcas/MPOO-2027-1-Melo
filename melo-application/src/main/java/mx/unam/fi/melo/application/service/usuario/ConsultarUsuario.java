package mx.unam.fi.melo.application.service.usuario;

import java.util.List;
import java.util.Optional;

import mx.unam.fi.domain.model.Usuario;

public interface ConsultarUsuario {

    List<Usuario> obtenerTodosUsuarios();

    Optional<Usuario> obtenerUsuarioPorId(Long id);

    Optional<Usuario> obtenerUsuarioPorEmail(String email);

}
