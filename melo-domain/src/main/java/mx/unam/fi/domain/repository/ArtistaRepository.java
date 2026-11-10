package mx.unam.fi.domain.repository;

import java.util.List;
import java.util.Optional;

import mx.unam.fi.domain.model.Artista;
import mx.unam.fi.domain.model.ArtistaId;

public interface ArtistaRepository {

    ArtistaId nextId();

    List<Artista> getAll();

    Optional<Artista> getById(ArtistaId id);

    Artista add(Artista artista);

    Artista update(ArtistaId id, Artista artista);

    void delete(ArtistaId id);

}
