package mx.unam.fi.melo.api.dto.inbound;

import mx.unam.fi.domain.model.GeneroMusical;

public class NuevaCancionRequest {

    private String titulo;
    private String url;
    private Long duracion;
    private GeneroMusical genero;
    private int numeroPista;

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public Long getDuracion() { return duracion; }
    public void setDuracion(Long duracion) { this.duracion = duracion; }

    public GeneroMusical getGenero() { return genero; }
    public void setGenero(GeneroMusical genero) { this.genero = genero; }

    public int getNumeroPista() { return numeroPista; }
    public void setNumeroPista(int numeroPista) { this.numeroPista = numeroPista; }
}
