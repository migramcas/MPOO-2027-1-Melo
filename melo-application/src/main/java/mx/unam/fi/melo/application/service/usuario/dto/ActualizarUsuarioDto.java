package mx.unam.fi.melo.application.service.usuario.dto;

import java.time.LocalDate;

public class ActualizarUsuarioDto {

    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private LocalDate fechaNacimiento;

    private ActualizarUsuarioDto(Builder builder) {
        this.nombre = builder.nombre;
        this.apellidoPaterno = builder.apellidoPaterno;
        this.apellidoMaterno = builder.apellidoMaterno;
        this.fechaNacimiento = builder.fechaNacimiento;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String nombre;
        private String apellidoPaterno;
        private String apellidoMaterno;
        private LocalDate fechaNacimiento;

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

        public ActualizarUsuarioDto build() {
            return new ActualizarUsuarioDto(this);
        }
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

}
