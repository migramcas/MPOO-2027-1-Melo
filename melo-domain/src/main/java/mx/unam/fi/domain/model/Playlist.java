package mx.unam.fi.domain.model;

import java.time.LocalDateTime;
import java.util.List;

public class Playlist {

    private final Long id;
    private final String nombre;
    private final List<ContenidoMultimedia> contenido;
    private final LocalDateTime fechaCreacion;
    private final LocalDateTime fechaUltimaActualizacion;
    private final Long creadoPor;
    private final Long actualizadoPor;

    private Playlist(Builder builder) {
        this.id = builder.id;
        this.nombre = builder.nombre;
        this.contenido = builder.contenido == null ? null : List.copyOf(builder.contenido);
        this.fechaCreacion = builder.fechaCreacion;
        this.fechaUltimaActualizacion = builder.fechaUltimaActualizacion;
        this.creadoPor = builder.creadoPor;
        this.actualizadoPor = builder.actualizadoPor;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Long id;
        private String nombre;
        private List<ContenidoMultimedia> contenido;
        private LocalDateTime fechaCreacion;
        private LocalDateTime fechaUltimaActualizacion;
        private Long creadoPor;
        private Long actualizadoPor;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder contenido(List<ContenidoMultimedia> contenido) {
            this.contenido = contenido;
            return this;
        }

        public Builder fechaCreacion(LocalDateTime fechaCreacion) {
            this.fechaCreacion = fechaCreacion;
            return this;
        }

        public Builder fechaUltimaActualizacion(LocalDateTime fechaUltimaActualizacion) {
            this.fechaUltimaActualizacion = fechaUltimaActualizacion;
            return this;
        }

        public Builder creadoPor(Long creadoPor) {
            this.creadoPor = creadoPor;
            return this;
        }

        public Builder actualizadoPor(Long actualizadoPor) {
            this.actualizadoPor = actualizadoPor;
            return this;
        }

        public Playlist build() {
            return new Playlist(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<ContenidoMultimedia> getContenido() {
        return contenido;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDateTime getFechaUltimaActualizacion() {
        return fechaUltimaActualizacion;
    }

    public Long getCreadoPor() {
        return creadoPor;
    }

    public Long getActualizadoPor() {
        return actualizadoPor;
    }
}
