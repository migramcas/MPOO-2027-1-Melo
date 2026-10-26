package mx.unam.domain;

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

    public Usuario(Long id, String nombreUsuario, DatosPersonales datosPersonales, Rol rol,
                   Long creadoPor) {
        this(id, nombreUsuario, datosPersonales, rol, LocalDateTime.now(), null, creadoPor, null);
    }

    private Usuario(Builder builder) {
        this(builder.id, builder.nombreUsuario, builder.datosPersonales, builder.rol,
                builder.fechaCreacion, builder.fechaUltimaActualizacion, builder.creadoPor,
                builder.actualizadoPor);
    }

    private Usuario(Long id, String nombreUsuario, DatosPersonales datosPersonales, Rol rol,
                    LocalDateTime fechaCreacion, LocalDateTime fechaUltimaActualizacion,
                    Long creadoPor, Long actualizadoPor) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.datosPersonales = datosPersonales;
        this.rol = rol;
        this.fechaCreacion = fechaCreacion;
        this.fechaUltimaActualizacion = fechaUltimaActualizacion != null
                ? fechaUltimaActualizacion : fechaCreacion;
        this.creadoPor = creadoPor;
        this.actualizadoPor = actualizadoPor;
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
            LocalDateTime fechaCreacion = this.fechaCreacion != null
                    ? this.fechaCreacion : LocalDateTime.now();
            return new Usuario(id, nombreUsuario, datosPersonales, rol, fechaCreacion,
                    fechaUltimaActualizacion, creadoPor, actualizadoPor);
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
