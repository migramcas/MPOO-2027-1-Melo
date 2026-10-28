package mx.unam.fi.melo.application.service.usuario;

@FunctionalInterface
public interface VerificarExistenciaEmail {

    boolean verificar(String email);

}
