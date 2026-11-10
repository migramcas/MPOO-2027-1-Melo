package mx.unam.fi.domain.repository;

import java.util.List;
import java.util.Optional;

import mx.unam.fi.domain.model.Playlist;

public interface PlaylistRepository {

    Long nextId();

    List<Playlist> getAll();

    Optional<Playlist> getById(Long id);

    Playlist add(Playlist playlist);

    Playlist update(Long id, Playlist playlist);

    void delete(Long id);

}
