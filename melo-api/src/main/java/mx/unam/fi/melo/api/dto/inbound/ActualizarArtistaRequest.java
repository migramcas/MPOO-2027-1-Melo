package mx.unam.fi.melo.api.dto.inbound;

import java.util.Set;
import mx.unam.fi.domain.model.GeneroMusical;

public class ActualizarArtistaRequest {

    private String nombreArtistico;
    private String biografia;
    private Set<GeneroMusical> generos;

    public String getNombreArtistico() { return nombreArtistico; }
    public void setNombreArtistico(String nombreArtistico) { this.nombreArtistico = nombreArtistico; }

    public String getBiografia() { return biografia; }
    public void setBiografia(String biografia) { this.biografia = biografia; }

    public Set<GeneroMusical> getGeneros() { return generos; }
    public void setGeneros(Set<GeneroMusical> generos) { this.generos = generos; }
}
