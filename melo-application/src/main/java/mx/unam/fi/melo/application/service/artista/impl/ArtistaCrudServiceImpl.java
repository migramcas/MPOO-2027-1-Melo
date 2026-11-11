package mx.unam.fi.melo.application.service.artista.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import mx.unam.fi.domain.model.Artista;
import mx.unam.fi.domain.model.ArtistaId;
import mx.unam.fi.domain.repository.ArtistaRepository;
import mx.unam.fi.melo.application.service.artista.ArtistaCrudService;
import mx.unam.fi.melo.application.service.artista.dto.ActualizarArtistaDto;
import mx.unam.fi.melo.application.service.artista.dto.CrearArtistaDto;

public class ArtistaCrudServiceImpl implements ArtistaCrudService {

    private final ArtistaRepository artistaRepository;

    public ArtistaCrudServiceImpl(ArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;
    }

    @Override
    public List<Artista> obtenerTodos() {
        return artistaRepository.getAll();
    }

    @Override
    public Optional<Artista> obtenerPorId(ArtistaId id) {
        Objects.requireNonNull(id, "El id no puede ser null");
        return artistaRepository.getById(id);
    }

    @Override
    public Artista crear(CrearArtistaDto dto) {
        Objects.requireNonNull(dto, "El DTO no puede ser null");

        ArtistaId artistaId = artistaRepository.nextId();

        Artista artista = Artista.builder()
                .id(artistaId)
                .nombreArtistico(dto.getNombreArtistico())
                .biografia(dto.getBiografia())
                .datosPersonales(dto.getDatosPersonales())
                .generos(dto.getGeneros())
                .build();

        return artistaRepository.add(artista);
    }

    @Override
    public Artista actualizar(ArtistaId id, ActualizarArtistaDto dto) {
        Objects.requireNonNull(id, "El id no puede ser null");
        Objects.requireNonNull(dto, "El DTO no puede ser null");

        Artista artistaExistente = artistaRepository.getById(id)
                .orElseThrow(() -> new IllegalStateException("Artista no encontrado"));

        Artista artistaActualizado = Artista.builder()
                .id(artistaExistente.getId())
                .nombreArtistico(dto.getNombreArtistico())
                .biografia(dto.getBiografia())
                .datosPersonales(artistaExistente.getDatosPersonales())
                .generos(dto.getGeneros())
                .build();

        return artistaRepository.update(id, artistaActualizado);
    }

    @Override
    public void eliminar(ArtistaId id) {
        Objects.requireNonNull(id, "El id no puede ser null");
        artistaRepository.delete(id);
    }

}
