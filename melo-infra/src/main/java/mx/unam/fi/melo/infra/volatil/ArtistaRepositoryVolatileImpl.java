package mx.unam.fi.melo.infra.volatil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import mx.unam.fi.domain.model.Artista;
import mx.unam.fi.domain.model.ArtistaId;
import mx.unam.fi.domain.repository.ArtistaRepository;

public class ArtistaRepositoryVolatileImpl implements ArtistaRepository {

    private static final List<Artista> listaArtistas = new ArrayList<>();

    @Override
    public ArtistaId nextId() {
        Long maxId = listaArtistas.stream()
                .map(Artista::getId)
                .map(ArtistaId::getId)
                .max(Comparator.naturalOrder())
                .orElse(0L);
        return ArtistaId.of(maxId + 1);
    }

    @Override
    public List<Artista> getAll() {
        return new ArrayList<>(listaArtistas);
    }

    @Override
    public Optional<Artista> getById(ArtistaId id) {
        if (id == null) {
            return Optional.empty();
        }
        return listaArtistas.stream()
                .filter(artista -> id.getId() == artista.getId().getId())
                .findFirst();
    }

    @Override
    public Artista add(Artista artista) {
        if (artista == null) {
            throw new IllegalArgumentException("El artista no puede ser null");
        }
        listaArtistas.add(artista);
        return artista;
    }

    @Override
    public Artista update(ArtistaId id, Artista artista) {
        if (id == null || artista == null) {
            throw new IllegalArgumentException("La información del artista es requerida");
        }

        for (int i = 0; i < listaArtistas.size(); i++) {
            Artista artistaExistente = listaArtistas.get(i);
            if (id.getId() == artistaExistente.getId().getId()) {
                listaArtistas.set(i, artista);
                return artista;
            }
        }

        throw new IllegalStateException("Artista con id " + id.getId() + " no encontrado");
    }

    @Override
    public void delete(ArtistaId id) {
        if (id == null) {
            throw new IllegalArgumentException("El id no puede ser null");
        }

        boolean eliminado = listaArtistas.removeIf(artista -> id.getId() == artista.getId().getId());

        if (!eliminado) {
            throw new IllegalStateException("Artista con id " + id.getId() + " no encontrado");
        }
    }
}
