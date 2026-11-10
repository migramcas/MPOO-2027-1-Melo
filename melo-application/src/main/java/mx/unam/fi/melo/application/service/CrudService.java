package mx.unam.fi.melo.application.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, ID, C, U> {

    List<T> obtenerTodos();
    Optional<T> obtenerPorId(ID id);
    T crear(C dto);
    T actualizar(ID id, U dto);
    void eliminar(ID id);

}
