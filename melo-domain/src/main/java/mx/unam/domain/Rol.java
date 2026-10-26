package mx.unam.domain;

public enum Rol {

    SUPER_ADMIN(1, "Este rol representa al root de la aplicación"),
    ADMIN (2, "Puede aplicar cambios en toda la aplicación pero no puede crear otros administradores"),
    USUARIO (3, "Este tipo de usuario es el estándar al crear una cuenta en la aplicación");

    private int id;
    private String descripcion;

    Rol(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
