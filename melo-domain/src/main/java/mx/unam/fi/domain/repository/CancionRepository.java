package mx.unam.fi.domain.repository;

import java.util.List;
import java.util.Optional;

import mx.unam.fi.domain.model.Cancion;

public interface CancionRepository {

    Long nextId();

    List<Cancion> getAll();

    Optional<Cancion> getById(Long id);

    Cancion add(Cancion cancion);

    Cancion update(Long id, Cancion cancion);

    void delete(Long id);

}
