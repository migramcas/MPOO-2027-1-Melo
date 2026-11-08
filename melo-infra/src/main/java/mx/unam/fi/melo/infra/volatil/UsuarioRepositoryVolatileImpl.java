package mx.unam.fi.melo.infra.volatil;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import mx.unam.fi.domain.model.Usuario;
import mx.unam.fi.domain.repository.UsuarioRepository;

public class UsuarioRepositoryVolatileImpl implements UsuarioRepository {

    public static final List<Usuario> listaUsuarios;

    static {
        listaUsuarios = new ArrayList<>();
    }

    @Override
    public List<Usuario> getAll() {
        return listaUsuarios;
    }

    @Override
    public Optional<Usuario> getById(Long id) {
        return listaUsuarios.stream()
                .filter(usuario -> usuario.getId().equals(id))
                .findFirst();
    }

    @Override
    public Optional<Usuario> getByEmail(String email) {
        return listaUsuarios.stream()
                .filter(usuario -> usuario.getDatosPersonales().getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    @Override
    public Usuario add(Usuario usuario) {
        listaUsuarios.add(usuario);
        return usuario;
    }

    @Override
    public Usuario update(Long id, Usuario usuario) {
        Optional<Usuario> usuarioExistente = getById(id);
        if (usuarioExistente.isPresent()) {
            listaUsuarios.remove(usuarioExistente.get());
            listaUsuarios.add(usuario);
            return usuario;
        } else {
            throw new IllegalStateException("Usuario con id " + id + " no encontrado");
        }
    }

    @Override
    public void delete(Long id) {
        Optional<Usuario> usuarioExistente = getById(id);
        if (usuarioExistente.isPresent()) {
            listaUsuarios.remove(usuarioExistente.get());
        } else {
            throw new IllegalStateException("Usuario con id " + id + " no encontrado");
        }
    }

}
