package mx.unam.fi.melo.application.service.artista.impl;

import java.util.List;
import java.util.Optional;

import mx.unam.fi.domain.model.Artista;
import mx.unam.fi.domain.model.ArtistaId;
import mx.unam.fi.melo.application.service.artista.ArtistaCrudService;
import mx.unam.fi.melo.application.service.artista.dto.ActualizarArtistaDto;
import mx.unam.fi.melo.application.service.artista.dto.NuevoArtistaDto;

public class ArtistaCrudServiceImpl implements ArtistaCrudService {

    @Override
    public List<Artista> obtenerTodos() {
        return List.of(
            Artista.builder()
            .id(ArtistaId.of(1L))
            .nombreArtistico("Artista 1")
            .biografia("Biografía del Artista 1")
            .build(), 
            
            Artista.builder()
            .id(ArtistaId.of(2L))
            .nombreArtistico("Artista 2")
            .biografia("Biografía del Artista 2")
            .build());

    }

    @Override
    public Optional<Artista> obtenerPorId(ArtistaId id) {
        throw new UnsupportedOperationException("Unimplemented method 'obtenerPorId'");
    }

    @Override
    public Artista crear(NuevoArtistaDto dto) {
        throw new UnsupportedOperationException("Unimplemented method 'crear'");
    }

    @Override
    public Artista actualizar(ArtistaId id, ActualizarArtistaDto dto) {
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

    @Override
    public void eliminar(ArtistaId id) {
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

}
