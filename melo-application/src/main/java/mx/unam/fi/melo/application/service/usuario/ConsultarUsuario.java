package mx.unam.fi.melo.application.service.usuario;

import java.util.Optional;

import mx.unam.fi.domain.model.Usuario;

public interface ConsultarUsuario {

    Optional<Usuario> obtenerUsuarioPorEmail(String email);

}
