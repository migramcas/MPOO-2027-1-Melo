package mx.unam.fi.domain.repository;

import java.util.List;
import java.util.Optional;

import mx.unam.fi.domain.model.Usuario;

public interface UsuarioRepository {

    List<Usuario> getAll();

    Optional<Usuario> getById(Long id);

    Optional<Usuario> getByEmail(String email);

    Usuario add(Usuario usuario);

    Usuario update(Long id, Usuario usuario);

    void delete(Long id);

}
