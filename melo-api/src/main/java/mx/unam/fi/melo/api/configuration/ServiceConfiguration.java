package mx.unam.fi.melo.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mx.unam.fi.domain.repository.ArtistaRepository;
import mx.unam.fi.domain.repository.CancionRepository;
import mx.unam.fi.domain.repository.PlaylistRepository;
import mx.unam.fi.domain.repository.UsuarioRepository;
import mx.unam.fi.melo.application.service.artista.ArtistaCrudService;
import mx.unam.fi.melo.application.service.artista.impl.ArtistaCrudServiceImpl;
import mx.unam.fi.melo.application.service.cancion.CancionCrudService;
import mx.unam.fi.melo.application.service.cancion.impl.CancionCrudServiceImpl;
import mx.unam.fi.melo.application.service.playlist.PlaylistCrudService;
import mx.unam.fi.melo.application.service.playlist.impl.PlaylistCrudServiceImpl;
import mx.unam.fi.melo.application.service.usuario.UsuarioCrudService;
import mx.unam.fi.melo.application.service.usuario.impl.UsuarioCrudServiceImpl;

@Configuration
public class ServiceConfiguration {

    @Bean
    public UsuarioCrudService usuarioCrudService(UsuarioRepository usuarioRepository) {
        return new UsuarioCrudServiceImpl(usuarioRepository);
    }

    @Bean
    public ArtistaCrudService artistaCrudService(ArtistaRepository artistaRepository) {
        return new ArtistaCrudServiceImpl(artistaRepository);
    }

    @Bean
    public CancionCrudService cancionCrudService(CancionRepository cancionRepository) {
        return new CancionCrudServiceImpl(cancionRepository);
    }

    @Bean
    public PlaylistCrudService playlistCrudService(PlaylistRepository playlistRepository) {
        return new PlaylistCrudServiceImpl(playlistRepository);
    }

}
