package mx.unam.fi.melo.application.service.artista.dto;

import java.util.Set;
import mx.unam.fi.domain.model.GeneroMusical;

public class ActualizarArtistaDto {

    private String nombreArtistico;
    private String biografia;
    private Set<GeneroMusical> generos;

    private ActualizarArtistaDto(Builder builder) {
        this.nombreArtistico = builder.nombreArtistico;
        this.biografia = builder.biografia;
        this.generos = builder.generos;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getNombreArtistico() { return nombreArtistico; }
    public String getBiografia() { return biografia; }
    public Set<GeneroMusical> getGeneros() { return generos; }

    public static class Builder {
        private String nombreArtistico;
        private String biografia;
        private Set<GeneroMusical> generos;

        public Builder nombreArtistico(String nombreArtistico) {
            this.nombreArtistico = nombreArtistico;
            return this;
        }

        public Builder biografia(String biografia) {
            this.biografia = biografia;
            return this;
        }

        public Builder generos(Set<GeneroMusical> generos) {
            this.generos = generos;
            return this;
        }

        public ActualizarArtistaDto build() {
            return new ActualizarArtistaDto(this);
        }
    }
}
