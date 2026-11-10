package mx.unam.fi.melo.application.service.playlist.dto;

import java.util.List;
import mx.unam.fi.domain.model.ContenidoMultimedia;

public class ActualizarPlaylistDto {
    private String nombre;
    private List<ContenidoMultimedia> contenido;
    private Long actualizadoPor;

    private ActualizarPlaylistDto(Builder builder) {
        this.nombre = builder.nombre;
        this.contenido = builder.contenido;
        this.actualizadoPor = builder.actualizadoPor;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getNombre() { return nombre; }
    public List<ContenidoMultimedia> getContenido() { return contenido; }
    public Long getActualizadoPor() { return actualizadoPor; }

    public static class Builder {
        private String nombre;
        private List<ContenidoMultimedia> contenido;
        private Long actualizadoPor;

        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder contenido(List<ContenidoMultimedia> contenido) {
            this.contenido = contenido;
            return this;
        }

        public Builder actualizadoPor(Long actualizadoPor) {
            this.actualizadoPor = actualizadoPor;
            return this;
        }

        public ActualizarPlaylistDto build() {
            return new ActualizarPlaylistDto(this);
        }
    }
}
