package mx.unam.fi.melo.application.service.playlist.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import mx.unam.fi.domain.model.Playlist;
import mx.unam.fi.domain.repository.PlaylistRepository;
import mx.unam.fi.melo.application.service.playlist.PlaylistCrudService;
import mx.unam.fi.melo.application.service.playlist.dto.ActualizarPlaylistDto;
import mx.unam.fi.melo.application.service.playlist.dto.InfoCrearPlaylistDto;

public class PlaylistCrudServiceImpl implements PlaylistCrudService {

    private final PlaylistRepository playlistRepository;

    public PlaylistCrudServiceImpl(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @Override
    public List<Playlist> obtenerTodos() {
        return playlistRepository.getAll();
    }

    @Override
    public Optional<Playlist> obtenerPorId(Long id) {
        Objects.requireNonNull(id, "El id no puede ser null");
        return playlistRepository.getById(id);
    }

    @Override
    public Playlist crear(InfoCrearPlaylistDto dto) {
        Objects.requireNonNull(dto, "El DTO no puede ser null");

        Long playlistId = playlistRepository.nextId();
        LocalDateTime ahora = LocalDateTime.now();

        Playlist playlist = Playlist.builder()
                .id(playlistId)
                .nombre(dto.getNombre())
                .contenido(dto.getContenido())
                .creadoPor(dto.getCreadoPor())
                .actualizadoPor(dto.getCreadoPor())
                .fechaCreacion(ahora)
                .fechaUltimaActualizacion(ahora)
                .build();

        return playlistRepository.add(playlist);
    }

    @Override
    public Playlist actualizar(Long id, ActualizarPlaylistDto dto) {
        Objects.requireNonNull(id, "El id no puede ser null");
        Objects.requireNonNull(dto, "El DTO no puede ser null");

        Playlist playlistExistente = playlistRepository.getById(id)
                .orElseThrow(() -> new IllegalStateException("Playlist no encontrada"));

        Playlist playlistActualizada = Playlist.builder()
                .id(playlistExistente.getId())
                .nombre(dto.getNombre())
                .contenido(dto.getContenido())
                .creadoPor(playlistExistente.getCreadoPor())
                .actualizadoPor(dto.getActualizadoPor())
                .fechaCreacion(playlistExistente.getFechaCreacion())
                .fechaUltimaActualizacion(LocalDateTime.now())
                .build();

        return playlistRepository.update(id, playlistActualizada);
    }

    @Override
    public void eliminar(Long id) {
        Objects.requireNonNull(id, "El id no puede ser null");
        playlistRepository.delete(id);
    }
}
