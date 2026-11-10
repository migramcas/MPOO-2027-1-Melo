package mx.unam.fi.melo.application.service.cancion.impl;

import java.util.List;
import java.util.Optional;

import mx.unam.fi.domain.model.Cancion;
import mx.unam.fi.melo.application.service.cancion.CancionCrudService;
import mx.unam.fi.melo.application.service.cancion.dto.ActualizarCancionDto;
import mx.unam.fi.melo.application.service.cancion.dto.NuevaCancionDto;

public class CancionCrudServiceImpl implements CancionCrudService {

    @Override
    public List<Cancion> obtenerTodos() {
        throw new UnsupportedOperationException("Unimplemented method 'obtenerTodos'");
    }

    @Override
    public Optional<Cancion> obtenerPorId(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'obtenerPorId'");
    }

    @Override
    public Cancion crear(NuevaCancionDto dto) {
        throw new UnsupportedOperationException("Unimplemented method 'crear'");
    }

    @Override
    public Cancion actualizar(Long id, ActualizarCancionDto dto) {
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

    @Override
    public void eliminar(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }
}
