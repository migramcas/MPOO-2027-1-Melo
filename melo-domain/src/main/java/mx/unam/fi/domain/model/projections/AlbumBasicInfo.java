package mx.unam.fi.domain.model.projections;

import java.time.LocalDate;
import java.util.List;

public record AlbumBasicInfo(
    Long id,
    String titulo,
    LocalDate fechaLanzamiento,
    List<String> artistas
) {
}
