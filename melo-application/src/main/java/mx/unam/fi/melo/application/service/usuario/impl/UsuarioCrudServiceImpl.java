package mx.unam.fi.melo.application.service.usuario.impl;

import java.util.List;
import java.util.Optional;

import mx.unam.fi.domain.model.Usuario;
import mx.unam.fi.melo.application.service.usuario.UsuarioCrudService;
import mx.unam.fi.melo.application.service.usuario.dto.ActualizarUsuarioDto;
import mx.unam.fi.melo.application.service.usuario.dto.NuevoUsuarioDto;

public class UsuarioCrudServiceImpl implements UsuarioCrudService {

    @Override
    public List<Usuario> obtenerTodosUsuarios() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerTodosUsuarios'");
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crear'");
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
