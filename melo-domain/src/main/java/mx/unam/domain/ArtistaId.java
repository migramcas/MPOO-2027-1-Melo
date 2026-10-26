package mx.unam.domain;

public class ArtistaId {

    private long id;

    public static ArtistaId of(Long id) {
        validate(id);
        return new ArtistaId(id);
    }

    private static void validate(Long id) {
        if(id == null || id < 0) {
            throw new IllegalArgumentException("El id debe ser mayor a 0 y no puede ser nulo");
        }
    }

    private ArtistaId(Long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
