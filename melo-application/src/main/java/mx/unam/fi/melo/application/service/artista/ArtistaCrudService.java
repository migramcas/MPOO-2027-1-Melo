package mx.unam.fi.melo.application.service.artista;

import mx.unam.fi.domain.model.Artista;
import mx.unam.fi.domain.model.ArtistaId;
import mx.unam.fi.melo.application.service.CrudService;
import mx.unam.fi.melo.application.service.artista.dto.ActualizarArtistaDto;
import mx.unam.fi.melo.application.service.artista.dto.NuevoArtistaDto;

public interface ArtistaCrudService extends CrudService<Artista, ArtistaId, NuevoArtistaDto, ActualizarArtistaDto> {
}
