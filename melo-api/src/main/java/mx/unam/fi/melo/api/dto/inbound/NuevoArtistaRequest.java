package mx.unam.fi.melo.api.dto.inbound;

import java.util.Set;
import mx.unam.fi.domain.model.DatosPersonales;
import mx.unam.fi.domain.model.GeneroMusical;

public class NuevoArtistaRequest {

    private String nombreArtistico;
    private String biografia;
    private DatosPersonales datosPersonales;
    private Set<GeneroMusical> generos;

    public String getNombreArtistico() { return nombreArtistico; }
    public void setNombreArtistico(String nombreArtistico) { this.nombreArtistico = nombreArtistico; }

    public String getBiografia() { return biografia; }
    public void setBiografia(String biografia) { this.biografia = biografia; }

    public DatosPersonales getDatosPersonales() { return datosPersonales; }
    public void setDatosPersonales(DatosPersonales datosPersonales) { this.datosPersonales = datosPersonales; }

    public Set<GeneroMusical> getGeneros() { return generos; }
    public void setGeneros(Set<GeneroMusical> generos) { this.generos = generos; }
}
