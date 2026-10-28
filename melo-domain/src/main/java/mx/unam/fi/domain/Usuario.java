package mx.unam.fi.domain;

import java.time.LocalDateTime;

public class Usuario {

    private final Long id;
    private final String nombreUsuario;
    private final DatosPersonales datosPersonales;
    private final Rol rol;
    private final LocalDateTime fechaCreacion;
    private final LocalDateTime fechaUltimaActualizacion;
    private final Long creadoPor;
    private final Long actualizadoPor;

    private Usuario(Builder builder) {
        this.id = builder.id;
        this.nombreUsuario = builder.nombreUsuario;
        this.datosPersonales = builder.datosPersonales;
        this.rol = builder.rol;
        this.fechaCreacion = builder.fechaCreacion;
        this.fechaUltimaActualizacion = builder.fechaUltimaActualizacion != null ? builder.fechaUltimaActualizacion
                : builder.fechaCreacion;
        this.creadoPor = builder.creadoPor;
        this.actualizadoPor = builder.actualizadoPor;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String nombreUsuario;
        private DatosPersonales datosPersonales;
        private Rol rol;
        private LocalDateTime fechaCreacion;
        private LocalDateTime fechaUltimaActualizacion;
        private Long creadoPor;
        private Long actualizadoPor;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder nombreUsuario(String nombreUsuario) {
            this.nombreUsuario = nombreUsuario;
            return this;
        }

        public Builder datosPersonales(DatosPersonales datosPersonales) {
            this.datosPersonales = datosPersonales;
            return this;
        }

        public Builder rol(Rol rol) {
            this.rol = rol;
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

        public Usuario build() {
            return new Usuario(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }

    public Rol getRol() {
        return rol;
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
