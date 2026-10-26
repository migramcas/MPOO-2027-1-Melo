package mx.unam.domain;

import java.util.Set;

public class Artista {

    private final ArtistaId id;
    private final String nombreArtistico;
    private final String biografia;
    private final DatosPersonales datosPersonales;
    private final Set<GeneroMusical> generos;

    private Artista(Builder builder) {
        this.id = builder.id;
        this.nombreArtistico = builder.nombreArtistico;
        this.biografia = builder.biografia;
        this.datosPersonales = builder.datosPersonales;
        this.generos = builder.generos;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ArtistaId id;
        private String nombreArtistico;
        private String biografia;
        private DatosPersonales datosPersonales;
        private Set<GeneroMusical> generos;

        public Builder id(ArtistaId id) {
            this.id = id;
            return this;
        }

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

        public Artista build() {
            return new Artista(this);
        }
    }

    public ArtistaId getId() {
        return id;
    }

    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public String getBiografia() {
        return biografia;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }

    public Set<GeneroMusical> getGeneros() {
        return generos;
    }
}
