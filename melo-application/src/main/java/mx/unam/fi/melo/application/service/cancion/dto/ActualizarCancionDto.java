package mx.unam.fi.melo.application.service.cancion.dto;

import mx.unam.fi.domain.model.GeneroMusical;

public class ActualizarCancionDto {

    private String titulo;
    private String url;
    private Long duracion;
    private GeneroMusical genero;
    private int numeroPista;

    private ActualizarCancionDto(Builder builder) {
        this.titulo = builder.titulo;
        this.url = builder.url;
        this.duracion = builder.duracion;
        this.genero = builder.genero;
        this.numeroPista = builder.numeroPista;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getTitulo() { return titulo; }
    public String getUrl() { return url; }
    public Long getDuracion() { return duracion; }
    public GeneroMusical getGenero() { return genero; }
    public int getNumeroPista() { return numeroPista; }

    public static class Builder {
        private String titulo;
        private String url;
        private Long duracion;
        private GeneroMusical genero;
        private int numeroPista;

        public Builder titulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder duracion(Long duracion) {
            this.duracion = duracion;
            return this;
        }

        public Builder genero(GeneroMusical genero) {
            this.genero = genero;
            return this;
        }

        public Builder numeroPista(int numeroPista) {
            this.numeroPista = numeroPista;
            return this;
        }

        public ActualizarCancionDto build() {
            return new ActualizarCancionDto(this);
        }
    }
}
