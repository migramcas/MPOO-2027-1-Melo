package mx.unam.fi.melo.application.service.playlist.dto;

import java.util.List;
import mx.unam.fi.domain.model.ContenidoMultimedia;

public class InfoCrearPlaylistDto {
    private String nombre;
    private List<ContenidoMultimedia> contenido;
    private Long creadoPor;

    private InfoCrearPlaylistDto(Builder builder) {
        this.nombre = builder.nombre;
        this.contenido = builder.contenido;
        this.creadoPor = builder.creadoPor;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getNombre() { return nombre; }
    public List<ContenidoMultimedia> getContenido() { return contenido; }
    public Long getCreadoPor() { return creadoPor; }

    public static class Builder {
        private String nombre;
        private List<ContenidoMultimedia> contenido;
        private Long creadoPor;

        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder contenido(List<ContenidoMultimedia> contenido) {
            this.contenido = contenido;
            return this;
        }

        public Builder creadoPor(Long creadoPor) {
            this.creadoPor = creadoPor;
            return this;
        }

        public InfoCrearPlaylistDto build() {
            return new InfoCrearPlaylistDto(this);
        }
    }
}
