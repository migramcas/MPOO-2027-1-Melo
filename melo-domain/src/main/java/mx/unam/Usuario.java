package usuario;

import java.time.LocalDateTime;

public class Usuario {

    private Long id;
    private String nombreUsuario;
    private DatosPersonales datosPersonales;
    private Rol rol;

    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaUltimaActualizacion;
    private Long creadoPor;
    private Long actualizadoPor;

    public Usuario() {
    }

    public Usuario(Long id, String nombreUsuario, DatosPersonales datosPersonales, Rol rol,
                   Long creadoPor) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.datosPersonales = datosPersonales;
        this.rol = rol;
        this.creadoPor = creadoPor;
        this.fechaCreacion = LocalDateTime.now();
        this.fechaUltimaActualizacion = this.fechaCreacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }

    public void setDatosPersonales(DatosPersonales datosPersonales) {
        this.datosPersonales = datosPersonales;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaUltimaActualizacion() {
        return fechaUltimaActualizacion;
    }

    public void setFechaUltimaActualizacion(LocalDateTime fechaUltimaActualizacion) {
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
    }

    public Long getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(Long creadoPor) {
        this.creadoPor = creadoPor;
    }

    public Long getActualizadoPor() {
        return actualizadoPor;
    }

    public void setActualizadoPor(Long actualizadoPor) {
        this.actualizadoPor = actualizadoPor;
    }
}
