package mx.unam.fi.melo.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mx.unam.fi.melo.application.service.artista.impl.ArtistaCrudServiceImpl;

@Configuration
public class ArtistaServiceConfiguration {

    @Bean
    public ArtistaCrudServiceImpl artistaCrudService() {
        return new ArtistaCrudServiceImpl();
    }

}
