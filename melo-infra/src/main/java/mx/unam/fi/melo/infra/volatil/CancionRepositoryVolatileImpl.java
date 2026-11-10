package mx.unam.fi.melo.infra.volatil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import mx.unam.fi.domain.model.Cancion;
import mx.unam.fi.domain.repository.CancionRepository;

public class CancionRepositoryVolatileImpl implements CancionRepository {

    private static final List<Cancion> listaCanciones = new ArrayList<>();

    @Override
    public Long nextId() {
        return listaCanciones.stream()
                .map(Cancion::getId)
                .filter(Objects::nonNull)
                .max(Comparator.naturalOrder())
                .map(id -> id + 1)
                .orElse(1L);
    }

    @Override
    public List<Cancion> getAll() {
        return new ArrayList<>(listaCanciones);
    }

    @Override
    public Optional<Cancion> getById(Long id) {
        if (id == null) {
            return Optional.empty();
        }
        return listaCanciones.stream()
                .filter(cancion -> id.equals(cancion.getId()))
                .findFirst();
    }

    @Override
    public Cancion add(Cancion cancion) {
        if (cancion == null) {
            throw new IllegalArgumentException("La canción no puede ser null");
        }
        listaCanciones.add(cancion);
        return cancion;
    }

    @Override
    public Cancion update(Long id, Cancion cancion) {
        if (id == null || cancion == null) {
            throw new IllegalArgumentException("La información de la canción es requerida");
        }

        for (int i = 0; i < listaCanciones.size(); i++) {
            Cancion cancionExistente = listaCanciones.get(i);
            if (id.equals(cancionExistente.getId())) {
                listaCanciones.set(i, cancion);
                return cancion;
            }
        }

        throw new IllegalStateException("Canción con id " + id + " no encontrada");
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El id no puede ser null");
        }

        boolean eliminado = listaCanciones.removeIf(cancion -> id.equals(cancion.getId()));

        if (!eliminado) {
            throw new IllegalStateException("Canción con id " + id + " no encontrada");
        }
    }
}
