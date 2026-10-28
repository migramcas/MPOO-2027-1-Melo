package mx.unam.fi.melo.infra.volatil;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import mx.unam.fi.domain.model.Usuario;
import mx.unam.fi.domain.repository.UsuarioRepository;

public class UsuarioRepositoryVolatileImpl implements UsuarioRepository {

    @Override
    public List<Usuario> getAll() {
        return new ArrayList<>();
    }

    @Override
    public Optional<Usuario> getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public Optional<Usuario> getByEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByEmail'");
    }

    @Override
    public Usuario add(Usuario usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public Usuario update(Long id, Usuario usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
