package mx.unam.fi.melo.application.service.cancion;

import mx.unam.fi.domain.model.Cancion;
import mx.unam.fi.melo.application.service.CrudService;
import mx.unam.fi.melo.application.service.cancion.dto.ActualizarCancionDto;
import mx.unam.fi.melo.application.service.cancion.dto.CrearCancionDto;

public interface CancionCrudService extends CrudService<Cancion, Long, CrearCancionDto, ActualizarCancionDto> {
}
