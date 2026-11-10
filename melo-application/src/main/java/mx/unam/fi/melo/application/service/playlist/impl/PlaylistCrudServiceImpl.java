package mx.unam.fi.melo.application.service.playlist.impl;

import java.util.List;
import java.util.Optional;

import mx.unam.fi.domain.model.Playlist;
import mx.unam.fi.melo.application.service.playlist.PlaylistCrudService;
import mx.unam.fi.melo.application.service.playlist.dto.ActualizarPlaylistDto;
import mx.unam.fi.melo.application.service.playlist.dto.NuevaPlaylistDto;

public class PlaylistCrudServiceImpl implements PlaylistCrudService {

    @Override
    public List<Playlist> obtenerTodos() {
        throw new UnsupportedOperationException("Unimplemented method 'obtenerTodos'");
    }

    @Override
    public Optional<Playlist> obtenerPorId(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'obtenerPorId'");
    }

    @Override
    public Playlist crear(NuevaPlaylistDto dto) {
        throw new UnsupportedOperationException("Unimplemented method 'crear'");
    }

    @Override
    public Playlist actualizar(Long id, ActualizarPlaylistDto dto) {
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

    @Override
    public void eliminar(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }
}
