package mx.unam.fi.melo.application.service.usuario.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import mx.unam.fi.domain.model.DatosPersonales;
import mx.unam.fi.domain.model.Rol;
import mx.unam.fi.domain.model.Usuario;
import mx.unam.fi.domain.repository.UsuarioRepository;
import mx.unam.fi.melo.application.service.usuario.UsuarioCrudService;
import mx.unam.fi.melo.application.service.usuario.dto.ActualizarUsuarioDto;
import mx.unam.fi.melo.application.service.usuario.dto.NuevoUsuarioDto;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerUsuarioPorId'");
    }

    @Override
    public Optional<Usuario> obtenerUsuarioPorEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerUsuarioPorEmail'");
    }

    @Override
    public Usuario crear(NuevoUsuarioDto usuario) {
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

    @Override
    public void eliminar(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

}
