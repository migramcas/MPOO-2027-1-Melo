package mx.unam.fi.melo.application.service.usuario.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import mx.unam.fi.domain.model.DatosPersonales;
import mx.unam.fi.domain.model.Rol;
import mx.unam.fi.domain.model.Usuario;
import mx.unam.fi.domain.repository.UsuarioRepository;
import mx.unam.fi.melo.application.service.usuario.UsuarioCrudService;
import mx.unam.fi.melo.application.service.usuario.dto.ActualizarUsuarioDto;
import mx.unam.fi.melo.application.service.usuario.dto.InfoCrearUsuarioDto;

public class UsuarioCrudServiceImpl implements UsuarioCrudService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioCrudServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> obtenerTodosUsuarios() {
        return usuarioRepository.getAll();
    }

    @Override
    public Optional<Usuario> obtenerUsuarioPorId(Long id) {
        Objects.requireNonNull(id, "El id no puede ser null");
        return usuarioRepository.getById(id);
    }

    @Override
    public Optional<Usuario> obtenerUsuarioPorEmail(String email) {
       Objects.requireNonNull(email, "El email no puede ser null");
        return usuarioRepository.getByEmail(email);
    }

    @Override
    public Usuario crear(InfoCrearUsuarioDto usuario) {
       Objects.requireNonNull(usuario, "El usuario no puede ser null");

        Optional<Usuario> usuarioGuardado = usuarioRepository.getByEmail(usuario.getEmail());
        if(usuarioGuardado.isPresent()) {
            throw new IllegalStateException("El usuario ya existe");
        }

        DatosPersonales datosPersonales = DatosPersonales.builder()
                .nombre(usuario.getNombre())
                .apellidoPaterno(usuario.getApellidoPaterno())
                .apellidoMaterno(usuario.getApellidoMaterno())
                .fechaNacimiento(usuario.getFechaNacimiento())
                .email(usuario.getEmail())
                .build();

        LocalDateTime fechaActual = LocalDateTime.now();

        Long usuarioId = usuarioRepository.nextId();

        return usuarioRepository.add(Usuario.builder()
                .id(usuarioId)
                .nombreUsuario(usuario.getNombreUsuario())
                .datosPersonales(datosPersonales)
                .rol(Rol.USUARIO)
                .fechaCreacion(fechaActual)
                .fechaUltimaActualizacion(fechaActual)
                .creadoPor(usuarioId)
                .actualizadoPor(usuarioId)
                .build());
    }

    @Override
    public Usuario actualizar(Long id, ActualizarUsuarioDto usuario) {
        Objects.requireNonNull(id, "El id no puede ser null");
        Objects.requireNonNull(usuario, "El usuario no puede ser null");

        Usuario usuarioExistente = usuarioRepository.getById(id)
                .orElseThrow(() -> new IllegalStateException("Usuario con id " + id + " no encontrado"));

        DatosPersonales datosPersonalesActuales = usuarioExistente.getDatosPersonales();

        DatosPersonales datosPersonalesActualizados = DatosPersonales.builder()
                .nombre(usuario.getNombre())
                .apellidoPaterno(usuario.getApellidoPaterno())
                .apellidoMaterno(usuario.getApellidoMaterno())
                .fechaNacimiento(usuario.getFechaNacimiento())
                .email(datosPersonalesActuales.getEmail())
                .build();

        Usuario usuarioActualizado = Usuario.builder()
                .id(usuarioExistente.getId())
                .nombreUsuario(usuarioExistente.getNombreUsuario())
                .datosPersonales(datosPersonalesActualizados)
                .rol(usuarioExistente.getRol())
                .fechaCreacion(usuarioExistente.getFechaCreacion())
                .fechaUltimaActualizacion(LocalDateTime.now())
                .creadoPor(usuarioExistente.getCreadoPor())
                .actualizadoPor(id)
                .build();

        return usuarioRepository.update(id, usuarioActualizado);
    }

    @Override
    public void eliminar(Long id) {
        Objects.requireNonNull(id, "El id no puede ser null");
        usuarioRepository.delete(id);
    }

    @Override
    public void eliminar(Long id, Rol rol) {
        Objects.requireNonNull(id, "El id no puede ser null");
        Usuario usuario = verificarExitenciaUsuario(id);
        verificarRolUsuario(rol, usuario);
        usuarioRepository.delete(id);
    }

    private void verificarRolUsuario(Rol rolEsperado, Usuario usuario) {
        if(usuario.getRol().equals(rolEsperado)) {
            throw new IllegalStateException("No se puede eliminar el usuario con rol " + usuario.getRol());
        }
    }

    private Usuario verificarExitenciaUsuario(Long id) {
        return obtenerUsuarioPorId(id)
                .orElseThrow(() -> new IllegalStateException("Usuario con id " + id + " no encontrado"));
    }

}
