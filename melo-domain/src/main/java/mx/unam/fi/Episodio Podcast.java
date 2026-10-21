public class EpisodioPodcast {
    
    private int numeroEpisodio;
    private String descripcion;

    
    public int getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void reproducir() {
        System.out.println("Reproduciendo el episodio número " + numeroEpisodio);
    }
}
