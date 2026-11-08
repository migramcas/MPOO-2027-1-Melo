package mx.unam.fi.melo.infra.mongo;

import mx.unam.fi.domain.model.Usuario;
import mx.unam.fi.domain.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

public class UsuarioRepositoryMongoImpl implements UsuarioRepository {
    @Override
    public List<Usuario> getAll() {
        return List.of();
    }

    @Override
    public Optional<Usuario> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Usuario> getByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Usuario add(Usuario usuario) {
        return null;
    }

    @Override
    public Usuario update(Long id, Usuario usuario) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
