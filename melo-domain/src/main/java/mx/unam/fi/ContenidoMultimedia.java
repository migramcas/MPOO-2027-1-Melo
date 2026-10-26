package mx.unam.fi;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class ContenidoMultimedia {

    private Long id;
    private String titulo;
    private int duracionSegundos;
    private LocalDate fechaPublicacion;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaUltimaActualizacion;
    private Long creadoPor;
    private Long actualizadoPor;

    public ContenidoMultimedia(Long id, String titulo, int duracionSegundos, LocalDate fechaPublicacion,
                               LocalDateTime fechaCreacion, LocalDateTime fechaUltimaActualizacion,
                               Long creadoPor, Long actualizadoPor) {
        this.id = id;
        this.titulo = titulo;
        this.duracionSegundos = duracionSegundos;
        this.fechaPublicacion = fechaPublicacion;
        this.fechaCreacion = fechaCreacion;
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
        this.creadoPor = creadoPor;
        this.actualizadoPor = actualizadoPor;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracionSegundos() {
        return duracionSegundos;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public abstract void reproducir();

    public abstract String getDescripcion();
}
