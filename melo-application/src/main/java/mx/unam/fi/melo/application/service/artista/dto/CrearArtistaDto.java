package mx.unam.fi.melo.application.service.artista.dto;

import java.util.Set;
import mx.unam.fi.domain.model.DatosPersonales;
import mx.unam.fi.domain.model.GeneroMusical;

public class CrearArtistaDto {

    private String nombreArtistico;
    private String biografia;
    private DatosPersonales datosPersonales;
    private Set<GeneroMusical> generos;

    private CrearArtistaDto(Builder builder) {
        this.nombreArtistico = builder.nombreArtistico;
        this.biografia = builder.biografia;
        this.datosPersonales = builder.datosPersonales;
        this.generos = builder.generos;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getNombreArtistico() { return nombreArtistico; }
    public String getBiografia() { return biografia; }
    public DatosPersonales getDatosPersonales() { return datosPersonales; }
    public Set<GeneroMusical> getGeneros() { return generos; }

    public static class Builder {
        private String nombreArtistico;
        private String biografia;
        private DatosPersonales datosPersonales;
        private Set<GeneroMusical> generos;

        public Builder nombreArtistico(String nombreArtistico) {
            this.nombreArtistico = nombreArtistico;
            return this;
        }

        public Builder biografia(String biografia) {
            this.biografia = biografia;
            return this;
        }

        public Builder datosPersonales(DatosPersonales datosPersonales) {
            this.datosPersonales = datosPersonales;
            return this;
        }

        public Builder generos(Set<GeneroMusical> generos) {
            this.generos = generos;
            return this;
        }

        public CrearArtistaDto build() {
            return new CrearArtistaDto(this);
        }
    }
}
