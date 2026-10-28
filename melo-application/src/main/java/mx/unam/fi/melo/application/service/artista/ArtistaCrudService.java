package mx.unam.fi.melo.application.service.artista;

import java.util.List;
import java.util.Optional;

import mx.unam.fi.domain.model.Artista;
import mx.unam.fi.domain.model.ArtistaId;

public interface ArtistaCrudService {

    List<Artista> getAll();

    Optional<Artista> getById(ArtistaId id);

    Artista add(Artista artista);

    Artista update(Artista artista);

    void delete(ArtistaId id);

}
