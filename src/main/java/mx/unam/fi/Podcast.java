package mx.unam.fi;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Podcast {

    private Long id;
    private String titulo;
    private String descripcion;
    private List<EpisodioPodcast> episodios;

    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaUltimaActualizacion;
    private Long creadoPor;
    private Long actualizadoPor;

    public Podcast() {
        this.episodios = new ArrayList<>();
        this.fechaCreacion = LocalDateTime.now();
        this.fechaUltimaActualizacion = this.fechaCreacion;
    }

    public Podcast(Long id, String titulo, String descripcion, Long creadoPor) {
        this();
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.creadoPor = creadoPor;
        this.actualizadoPor = creadoPor;
    }

    // ----- Métodos del diagrama -----

    public void agregarEpisodio(EpisodioPodcast episodio) {
        if (episodio == null) {
            throw new IllegalArgumentException("El episodio no puede ser nulo");
        }
        this.episodios.add(episodio);
        this.fechaUltimaActualizacion = LocalDateTime.now();
    }

    public List<EpisodioPodcast> getEpisodios() {
        return episodios;
    }

    public int calcularDuracionTotal() {
        int total = 0;
        for (EpisodioPodcast episodio : episodios) {
            total += episodio.getDuracion(); // ajusta al nombre real del getter
        }
        return total;
    }

    // ----- Getters y setters -----

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public LocalDateTime getFechaUltimaActualizacion() { return fechaUltimaActualizacion; }
    public void setFechaUltimaActualizacion(LocalDateTime fechaUltimaActualizacion) {
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
    }

    public Long getCreadoPor() { return creadoPor; }
    public void setCreadoPor(Long creadoPor) { this.creadoPor = creadoPor; }

    public Long getActualizadoPor() { return actualizadoPor; }
    public void setActualizadoPor(Long actualizadoPor) { this.actualizadoPor = actualizadoPor; }
}
