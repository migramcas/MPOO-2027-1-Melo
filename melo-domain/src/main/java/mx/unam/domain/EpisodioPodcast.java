package mx.unam.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EpisodioPodcast extends ContenidoMultimedia {

  private int numeroEpisodio;
  private String descripcion;

  private EpisodioPodcast(Builder builder) {
    super(builder);
    this.numeroEpisodio = builder.numeroEpisodio;
    this.descripcion = builder.descripcion;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends ContenidoMultimedia.Builder<EpisodioPodcast, Builder> {

    private int numeroEpisodio;
    private String descripcion;

    public Builder numeroEpisodio(int numeroEpisodio) {
      this.numeroEpisodio = numeroEpisodio;
      return self();
    }

    public Builder descripcion(String descripcion) {
      this.descripcion = descripcion;
      return self();
    }

    @Override
    protected Builder self() {
      return this;
    }

    @Override
    public EpisodioPodcast build() {
      return new EpisodioPodcast(this);
    }
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
