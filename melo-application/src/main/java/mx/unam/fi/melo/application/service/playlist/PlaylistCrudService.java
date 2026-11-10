package mx.unam.fi.melo.application.service.playlist;

import mx.unam.fi.domain.model.Playlist;
import mx.unam.fi.melo.application.service.CrudService;
import mx.unam.fi.melo.application.service.playlist.dto.ActualizarPlaylistDto;
import mx.unam.fi.melo.application.service.playlist.dto.NuevaPlaylistDto;

public interface PlaylistCrudService extends CrudService<Playlist, Long, NuevaPlaylistDto, ActualizarPlaylistDto> {
}
