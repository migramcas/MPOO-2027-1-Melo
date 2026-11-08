package mx.unam.fi.melo.api.configuration;

import mx.unam.fi.domain.repository.UsuarioRepository;
import mx.unam.fi.melo.infra.volatil.UsuarioRepositoryVolatileImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioRepositoryConfiguration {

    @Bean
    public UsuarioRepository usuarioRepository() {
        return new UsuarioRepositoryVolatileImpl();
    }

}
