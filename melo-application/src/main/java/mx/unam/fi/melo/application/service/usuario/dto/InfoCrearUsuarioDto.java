package mx.unam.fi.melo.application.service.usuario.dto;

import mx.unam.fi.domain.model.Rol;

import java.time.LocalDate;

public class InfoCrearUsuarioDto {

    private final Rol rol;
    private final String nombreUsuario;
    private final String nombre;
    private final String apellidoPaterno;
    private final String apellidoMaterno;
    private final LocalDate fechaNacimiento;
    private final String email;
    private final Long creadoPor;

    private InfoCrearUsuarioDto(Builder builder) {
        this.rol = builder.rol != null ? builder.rol : Rol.USUARIO;
        this.nombreUsuario = builder.nombreUsuario;
        this.nombre = builder.nombre;
        this.apellidoPaterno = builder.apellidoPaterno;
        this.apellidoMaterno = builder.apellidoMaterno;
        this.fechaNacimiento = builder.fechaNacimiento;
        this.email = builder.email;
        this.creadoPor = builder.creadoPor;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Rol rol;
        private String nombreUsuario;
        private String nombre;
        private String apellidoPaterno;
        private String apellidoMaterno;
        private LocalDate fechaNacimiento;
        private String email;
        private Long creadoPor;

        public Builder rol(Rol rol) {
            this.rol = rol;
            return this;
        }

        public Builder nombreUsuario(String nombreUsuario) {
            this.nombreUsuario = nombreUsuario;
            return this;
        }

        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder apellidoPaterno(String apellidoPaterno) {
            this.apellidoPaterno = apellidoPaterno;
            return this;
        }

        public Builder apellidoMaterno(String apellidoMaterno) {
            this.apellidoMaterno = apellidoMaterno;
            return this;
        }

        public Builder fechaNacimiento(LocalDate fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder creadoPor(Long creadoPor) {
            this.creadoPor = creadoPor;
        }

        public InfoCrearUsuarioDto build() {
            return new InfoCrearUsuarioDto(this);
        }
    }

    public Rol getRol() {
        return rol;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public Long getCreadoPor() {
        return creadoPor;
    }

}
