package mx.unam.fi;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Playlist {

    private Long id;
    private String nombre;
    private List<ContenidoMultimedia> contenidos;

    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaUltimaActualizacion;
    private Long creadoPor;
    private Long actualizadoPor;

    public Playlist() {
        this.contenidos = new ArrayList<>();
        this.fechaCreacion = LocalDateTime.now();
        this.fechaUltimaActualizacion = this.fechaCreacion;
    }

    public Playlist(Long id, String nombre, Long creadoPor) {
        this();
        this.id = id;
        this.nombre = nombre;
        this.creadoPor = creadoPor;
        this.actualizadoPor = creadoPor;
    }

    // ----- Métodos del diagrama -----

    public void agregar(ContenidoMultimedia contenido) {
        if (contenido == null) {
            throw new IllegalArgumentException("El contenido no puede ser nulo");
        }
        contenidos.add(contenido);
        fechaUltimaActualizacion = LocalDateTime.now();
    }

    public boolean eliminar(Long idContenido) {
        boolean eliminado = false;
        Iterator<ContenidoMultimedia> it = contenidos.iterator();
        while (it.hasNext()) {
            if (it.next().getId().equals(idContenido)) { // ajusta al getter real
                it.remove();
                eliminado = true;
                break;
            }
        }
        if (eliminado) {
            fechaUltimaActualizacion = LocalDateTime.now();
        }
        return eliminado;
    }

    public List<ContenidoMultimedia> getContenidos() {
        return contenidos;
    }

    public int getDuracionTotal() {
        int total = 0;
        for (ContenidoMultimedia contenido : contenidos) {
            total += contenido.getDuracion(); // ajusta al getter real
        }
        return total;
    }

    public void reproducirTodo() {
        for (ContenidoMultimedia contenido : contenidos) {
            contenido.reproducir(); // ajusta al método real
        }
    }

    // ----- Getters y setters -----

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

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
