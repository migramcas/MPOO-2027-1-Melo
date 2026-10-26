package mx.unam.domain;

import java.time.LocalDate;

public class DatosPersonales {

    private final String nombre;
    private final String apellidoPaterno;
    private final String apellidoMaterno;
    private final LocalDate fechaNacimiento;
    private final String email;

    private DatosPersonales(Builder builder) {
        this.nombre = builder.nombre;
        this.apellidoPaterno = builder.apellidoPaterno;
        this.apellidoMaterno = builder.apellidoMaterno;
        this.fechaNacimiento = builder.fechaNacimiento;
        this.email = builder.email;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String nombre;
        private String apellidoPaterno;
        private String apellidoMaterno;
        private LocalDate fechaNacimiento;
        private String email;

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

        public DatosPersonales build() {
            return new DatosPersonales(this);
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

    public String getEmail() {
        return email;
    }
}
