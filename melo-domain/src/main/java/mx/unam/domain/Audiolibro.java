package mx.unam.domain;

public class Audiolibro extends ContenidoMultimedia {

  private String autor;
  private String narrador;

  private Audiolibro(Builder builder) {
    super(builder);
    this.autor = builder.autor;
    this.narrador = builder.narrador;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends ContenidoMultimedia.Builder<Audiolibro, Builder> {

    private String autor;
    private String narrador;

    public Builder autor(String autor) {
      this.autor = autor;
      return self();
    }

    public Builder narrador(String narrador) {
      this.narrador = narrador;
      return self();
    }

    @Override
    protected Builder self() {
      return this;
    }

    @Override
    public Audiolibro build() {
      return new Audiolibro(this);
    }
  }

  public String getAutor() {
    return autor;
  }

  public void reproducir() {
    System.out.println("Reproduciendo audiolibro: " + getTitulo());
  }

  public String getDescripcion() {
    return "Audiolibro - Autor: " + autor + ", Narrador: " + narrador;
  }
}
