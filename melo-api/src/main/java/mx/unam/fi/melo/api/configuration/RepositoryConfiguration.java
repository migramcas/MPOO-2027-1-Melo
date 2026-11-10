package mx.unam.fi.melo.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mx.unam.fi.domain.repository.ArtistaRepository;
import mx.unam.fi.domain.repository.CancionRepository;
import mx.unam.fi.domain.repository.PlaylistRepository;
import mx.unam.fi.domain.repository.UsuarioRepository;
import mx.unam.fi.melo.infra.volatil.ArtistaRepositoryVolatileImpl;
import mx.unam.fi.melo.infra.volatil.CancionRepositoryVolatileImpl;
import mx.unam.fi.melo.infra.volatil.PlaylistRepositoryVolatileImpl;
import mx.unam.fi.melo.infra.volatil.UsuarioRepositoryVolatileImpl;

@Configuration
public class RepositoryConfiguration {

    @Bean
    public UsuarioRepository usuarioRepository() {
        return new UsuarioRepositoryVolatileImpl();
    }

    @Bean
    public ArtistaRepository artistaRepository() {
        return new ArtistaRepositoryVolatileImpl();
    }

    @Bean
    public CancionRepository cancionRepository() {
        return new CancionRepositoryVolatileImpl();
    }

    @Bean
    public PlaylistRepository playlistRepository() {
        return new PlaylistRepositoryVolatileImpl();
    }

}
