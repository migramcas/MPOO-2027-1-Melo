package mx.unam.fi.melo.infra.volatil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import mx.unam.fi.domain.model.Playlist;
import mx.unam.fi.domain.repository.PlaylistRepository;

public class PlaylistRepositoryVolatileImpl implements PlaylistRepository {

    private static final List<Playlist> listaPlaylists = new ArrayList<>();

    @Override
    public Long nextId() {
        return listaPlaylists.stream()
                .map(Playlist::getId)
                .filter(Objects::nonNull)
                .max(Comparator.naturalOrder())
                .map(id -> id + 1)
                .orElse(1L);
    }

    @Override
    public List<Playlist> getAll() {
        return new ArrayList<>(listaPlaylists);
    }

    @Override
    public Optional<Playlist> getById(Long id) {
        if (id == null) {
            return Optional.empty();
        }
        return listaPlaylists.stream()
                .filter(playlist -> id.equals(playlist.getId()))
                .findFirst();
    }

    @Override
    public Playlist add(Playlist playlist) {
        if (playlist == null) {
            throw new IllegalArgumentException("La playlist no puede ser null");
        }
        listaPlaylists.add(playlist);
        return playlist;
    }

    @Override
    public Playlist update(Long id, Playlist playlist) {
        if (id == null || playlist == null) {
            throw new IllegalArgumentException("La información de la playlist es requerida");
        }

        for (int i = 0; i < listaPlaylists.size(); i++) {
            Playlist playlistExistente = listaPlaylists.get(i);
            if (id.equals(playlistExistente.getId())) {
                listaPlaylists.set(i, playlist);
                return playlist;
            }
        }

        throw new IllegalStateException("Playlist con id " + id + " no encontrada");
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El id no puede ser null");
        }

        boolean eliminado = listaPlaylists.removeIf(playlist -> id.equals(playlist.getId()));

        if (!eliminado) {
            throw new IllegalStateException("Playlist con id " + id + " no encontrada");
        }
    }
}
