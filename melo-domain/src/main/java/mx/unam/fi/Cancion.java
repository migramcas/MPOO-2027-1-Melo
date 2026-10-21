package mx.unam.fi.contenido; 

public class Cancion extends ContenidoMultimedia {
    private GeneroMusical genero;
    private int numeroPista;

    public Cancion(Long id, String titulo, int duracionSegundos, java.time.LocalDate fechaPublicacion,
                   GeneroMusical genero, int numeroPista) {
        super(id, titulo, duracionSegundos, fechaPublicacion); 
        this.genero = genero;
        this.numeroPista = numeroPista;
    }

    public GeneroMusical getGenero() {
        return genero;
    }

    public void setGenero(GeneroMusical genero) {
        this.genero = genero;
    }
    
    public int getNumeroPista() {
        return numeroPista;
    }

    public void setNumeroPista(int numeroPista) {
        this.numeroPista = numeroPista;
    }

    @Override
    public void reproducir() {
       
        System.out.println("Reproduciendo canción...");
    }

    @Override
    public String getDescripcion() {
        return "Canción - Pista: " + numeroPista + ", Género: " + genero;
    }
}