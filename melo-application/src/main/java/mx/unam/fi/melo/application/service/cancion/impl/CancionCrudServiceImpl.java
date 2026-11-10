package mx.unam.fi.melo.application.service.cancion.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import mx.unam.fi.domain.model.Cancion;
import mx.unam.fi.domain.repository.CancionRepository;
import mx.unam.fi.melo.application.service.cancion.CancionCrudService;
import mx.unam.fi.melo.application.service.cancion.dto.ActualizarCancionDto;
import mx.unam.fi.melo.application.service.cancion.dto.NuevaCancionDto;

public class CancionCrudServiceImpl implements CancionCrudService {

    private final CancionRepository cancionRepository;

    public CancionCrudServiceImpl(CancionRepository cancionRepository) {
        this.cancionRepository = cancionRepository;
    }

    @Override
    public List<Cancion> obtenerTodos() {
        return cancionRepository.getAll();
    }

    @Override
    public Optional<Cancion> obtenerPorId(Long id) {
        Objects.requireNonNull(id, "El id no puede ser null");
        return cancionRepository.getById(id);
    }

    @Override
    public Cancion crear(NuevaCancionDto dto) {
        Objects.requireNonNull(dto, "El DTO no puede ser null");

        Long cancionId = cancionRepository.nextId();
        LocalDateTime ahora = LocalDateTime.now();

        Cancion cancion = Cancion.builder()
                .id(cancionId)
                .titulo(dto.getTitulo())
                .duracionSegundos(dto.getDuracion() != null ? dto.getDuracion().intValue() : 0)
                .genero(dto.getGenero())
                .numeroPista(dto.getNumeroPista())
                .fechaCreacion(ahora)
                .fechaUltimaActualizacion(ahora)
                .build();

        return cancionRepository.add(cancion);
    }

    @Override
    public Cancion actualizar(Long id, ActualizarCancionDto dto) {
        Objects.requireNonNull(id, "El id no puede ser null");
        Objects.requireNonNull(dto, "El DTO no puede ser null");

        Cancion cancionExistente = cancionRepository.getById(id)
                .orElseThrow(() -> new IllegalStateException("Canción no encontrada"));

        Cancion cancionActualizada = Cancion.builder()
                .id(cancionExistente.getId())
                .titulo(dto.getTitulo())
                .duracionSegundos(dto.getDuracion() != null ? dto.getDuracion().intValue() : 0)
                .genero(dto.getGenero())
                .numeroPista(dto.getNumeroPista())
                .fechaCreacion(cancionExistente.getFechaCreacion())
                .fechaUltimaActualizacion(LocalDateTime.now())
                .creadoPor(cancionExistente.getCreadoPor())
                .build();

        return cancionRepository.update(id, cancionActualizada);
    }

    @Override
    public void eliminar(Long id) {
        Objects.requireNonNull(id, "El id no puede ser null");
        cancionRepository.delete(id);
    }
}
