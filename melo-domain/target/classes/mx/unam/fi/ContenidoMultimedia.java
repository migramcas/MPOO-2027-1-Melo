import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class ContenidoMultimedia implements Reproducible {
    
    private Long id;
    private String titulo;
    private int duracionSegundos;
    private LocalDate fechaPublicacion;

    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaUltimaActualizacion;
    private Long creadoPor;
    private Long actualizadoPor;

    public ContenidoMultimedia() {
    }

    public ContenidoMultimedia(Long id, String titulo, int duracionSegundos, LocalDate fechaPublicacion, LocalDateTime fechaCreacion, LocalDateTime fechaUltimaActualizacion, Long creadoPor, Long actualizadoPor) {
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

    public void setId(Long id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setDuracionSegundos(int duracionSegundos) { this.duracionSegundos = duracionSegundos; }
    public void setFechaPublicacion(LocalDate fechaPublicacion) { this.fechaPublicacion = fechaPublicacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
    public void setFechaUltimaActualizacion(LocalDateTime fechaUltimaActualizacion) { this.fechaUltimaActualizacion = fechaUltimaActualizacion; }
    public void setCreadoPor(Long creadoPor) { this.creadoPor = creadoPor; }
    public void setActualizadoPor(Long actualizadoPor) { this.actualizadoPor = actualizadoPor; }

    @Override
    public abstract void reproducir();

    public abstract String getDescripcion();
}
