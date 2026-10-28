package mx.unam.fi.melo.application.service.artista.impl;

import java.util.List;
import java.util.Optional;

import mx.unam.fi.domain.model.Artista;
import mx.unam.fi.domain.model.ArtistaId;
import mx.unam.fi.melo.application.service.artista.ArtistaCrudService;

public class ArtistaCrudServiceImpl implements ArtistaCrudService {

    @Override
    public List<Artista> getAll() {
        return List.of(Artista.builder().id(ArtistaId.of(1L)).nombreArtistico("Artista 1")
                .biografia("Biografía del Artista 1").build(), Artista.builder().id(ArtistaId.of(2L

        )).nombreArtistico("Artista 2").biografia("Biografía del Artista 2").build());

    }

    @Override
    public Optional<Artista> getById(ArtistaId id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public Artista add(Artista artista) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public Artista update(Artista artista) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(ArtistaId id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    // Implementación de los métodos de la interfaz ArtistaCrudService

}
