package mx.unam.fi.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class ContenidoMultimedia {

  private Long id;
  private String titulo;
  private int duracionSegundos;
  private LocalDate fechaPublicacion;
  private LocalDateTime fechaCreacion;
  private LocalDateTime fechaUltimaActualizacion;
  private Long creadoPor;
  private Long actualizadoPor;

  protected ContenidoMultimedia(Builder<?, ?> builder) {
    this.id = builder.id;
    this.titulo = builder.titulo;
    this.duracionSegundos = builder.duracionSegundos;
    this.fechaPublicacion = builder.fechaPublicacion;
    this.fechaCreacion = builder.fechaCreacion;
    this.fechaUltimaActualizacion = builder.fechaUltimaActualizacion;
    this.creadoPor = builder.creadoPor;
    this.actualizadoPor = builder.actualizadoPor;
  }

  public abstract static class Builder<T extends ContenidoMultimedia, B extends Builder<T, B>> {

    protected Long id;
    protected String titulo;
    protected int duracionSegundos;
    protected LocalDate fechaPublicacion;
    protected LocalDateTime fechaCreacion;
    protected LocalDateTime fechaUltimaActualizacion;
    protected Long creadoPor;
    protected Long actualizadoPor;

    protected abstract B self();

    public abstract T build();

    public B id(Long id) {
      this.id = id;
      return self();
    }

    public B titulo(String titulo) {
      this.titulo = titulo;
      return self();
    }

    public B duracionSegundos(int duracionSegundos) {
      this.duracionSegundos = duracionSegundos;
      return self();
    }

    public B fechaPublicacion(LocalDate fechaPublicacion) {
      this.fechaPublicacion = fechaPublicacion;
      return self();
    }

    public B fechaCreacion(LocalDateTime fechaCreacion) {
      this.fechaCreacion = fechaCreacion;
      return self();
    }

    public B fechaUltimaActualizacion(LocalDateTime fechaUltimaActualizacion) {
      this.fechaUltimaActualizacion = fechaUltimaActualizacion;
      return self();
    }

    public B creadoPor(Long creadoPor) {
      this.creadoPor = creadoPor;
      return self();
    }

    public B actualizadoPor(Long actualizadoPor) {
      this.actualizadoPor = actualizadoPor;
      return self();
    }
  }

  public Long getId() {
    return id;
  }

  public String getTitulo() {
    return titulo;
  }

  public int getDuracionSegundos() {
    return duracionSegundos;
  }

  public LocalDate getFechaPublicacion() {
    return fechaPublicacion;
  }

  public LocalDateTime getFechaCreacion() {
    return fechaCreacion;
  }

  public LocalDateTime getFechaUltimaActualizacion() {
    return fechaUltimaActualizacion;
  }

  public Long getCreadoPor() {
    return creadoPor;
  }

  public Long getActualizadoPor() {
    return actualizadoPor;
  }

}
