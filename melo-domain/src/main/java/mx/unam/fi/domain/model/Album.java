package mx.unam.fi.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Album {

    private Long id;
    private String titulo;
    private LocalDate fechaLanzamiento;
    private List<Cancion> canciones;
    private Set<Long> artistas;

    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaUltimaActualizacion;
    private Long creadoPor;
    private Long actualizadoPor;

    private Album(Builder builder) {
        this.id = builder.id;
        this.titulo = builder.titulo;
        this.fechaLanzamiento = builder.fechaLanzamiento;
        this.canciones = builder.canciones != null ? builder.canciones : new ArrayList<>();
        this.artistas = builder.artistas != null ? builder.artistas : new HashSet<>();
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
        private String titulo;
        private LocalDate fechaLanzamiento;
        private List<Cancion> canciones;
        private Set<Long> artistas;
        private LocalDateTime fechaCreacion;
        private LocalDateTime fechaUltimaActualizacion;
        private Long creadoPor;
        private Long actualizadoPor;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder titulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public Builder fechaLanzamiento(LocalDate fechaLanzamiento) {
            this.fechaLanzamiento = fechaLanzamiento;
            return this;
        }

        public Builder canciones(List<Cancion> canciones) {
            this.canciones = canciones;
            return this;
        }

        public Builder artistas(Set<Long> artistas) {
            this.artistas = artistas;
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

        public Album build() {
            return new Album(this);
        }
    }

    public void agregarCancion(Cancion cancion) {
        if (cancion != null) {
            this.canciones.add(cancion);
        }
    }

    public List<Cancion> getCanciones() {
        return new ArrayList<>(canciones);
    }

    public int getDuracionTotal() {
        return canciones.stream()
                .mapToInt(Cancion::getDuracionSegundos)
                .sum();
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public Set<Long> getArtistas() {
        return artistas;
    }

    public void setArtistas(Set<Long> artistas) {
        this.artistas = artistas;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaUltimaActualizacion() {
        return fechaUltimaActualizacion;
    }

    public void setFechaUltimaActualizacion(LocalDateTime fechaUltimaActualizacion) {
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
    }

    public Long getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(Long creadoPor) {
        this.creadoPor = creadoPor;
    }

    public Long getActualizadoPor() {
        return actualizadoPor;
    }

    public void setActualizadoPor(Long actualizadoPor) {
        this.actualizadoPor = actualizadoPor;
    }
}
