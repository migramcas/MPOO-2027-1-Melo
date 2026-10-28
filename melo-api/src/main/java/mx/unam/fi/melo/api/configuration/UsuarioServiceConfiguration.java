package mx.unam.fi.melo.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mx.unam.fi.melo.application.service.usuario.UsuarioCrudService;
import mx.unam.fi.melo.application.service.usuario.impl.UsuarioCrudServiceImpl;

@Configuration
public class UsuarioServiceConfiguration {

    @Bean
    public UsuarioCrudService usuarioCrudService() {
        return new UsuarioCrudServiceImpl();
    }

}
