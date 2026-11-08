package mx.unam.fi.melo.infra.volatil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import mx.unam.fi.domain.model.Usuario;
import mx.unam.fi.domain.repository.UsuarioRepository;

public class UsuarioRepositoryVolatileImpl implements UsuarioRepository {

    public static final List<Usuario> listaUsuarios;

    static {
        listaUsuarios = new ArrayList<>();
    }

    @Override
    public Long nextId() {
        return listaUsuarios.stream()
                .map(Usuario::getId)
                .filter(Objects::nonNull)
                .max(Comparator.naturalOrder())
                .map(id -> id + 1)
                .orElse(1L);
    }

    @Override
    public List<Usuario> getAll() {
        return new ArrayList<>(listaUsuarios);
    }

    @Override
    public Optional<Usuario> getById(Long id) {
        if (id == null) {
            return Optional.empty();
        }
        return listaUsuarios.stream()
                .filter(usuario -> id.equals(usuario.getId()))
                .findFirst();
    }

    @Override
    public Optional<Usuario> getByEmail(String email) {
        if (email == null || email.isBlank()) {
            return Optional.empty();
        }
        return listaUsuarios.stream()
                .filter(usuario -> usuario.getDatosPersonales().getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    @Override
    public Usuario add(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario no puede ser null");
        }
        listaUsuarios.add(usuario);
        return usuario;
    }

    @Override
    public Usuario update(Long id, Usuario usuario) {
        if (id == null || usuario == null) {
            throw new IllegalArgumentException("La información del usuario es requerida");
        }

        for (int i = 0; i < listaUsuarios.size(); i++) {
            Usuario usuarioExistente = listaUsuarios.get(i);
            if (id.equals(usuarioExistente.getId())) {
                listaUsuarios.set(i, usuario);
                return usuario;
            }
        }

        throw new IllegalStateException("Usuario con id " + id + " no encontrado");
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El id no puede ser null");
        }

        boolean eliminado = listaUsuarios.removeIf(usuario -> id.equals(usuario.getId()));

        if (!eliminado) {
            throw new IllegalStateException("Usuario con id " + id + " no encontrado");
        }
    }

}
