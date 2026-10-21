import java.time.LocalDate;
import java.time.LocalDateTime;

public class EpisodioPodcast extends ContenidoMultimedia {

    private int numeroEpisodio;
    private String descripcion;

    public EpisodioPodcast(Long id, String titulo, int duracionSegundos, LocalDate fechaPublicacion, 
                           LocalDateTime fechaCreacion, LocalDateTime fechaUltimaActualizacion, 
                           Long creadoPor, Long actualizadoPor, int numeroEpisodio, String descripcion) {
        
        super(id, titulo, duracionSegundos, fechaPublicacion, fechaCreacion, 
              fechaUltimaActualizacion, creadoPor, actualizadoPor);
        
        this.numeroEpisodio = numeroEpisodio;
        this.descripcion = descripcion;
    }

    public int getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo episodio " + numeroEpisodio + ": " + getTitulo());
    }
}
