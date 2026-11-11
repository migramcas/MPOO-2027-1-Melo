package mx.unam.fi.melo.application.service.usuario.exception;

import mx.unam.fi.melo.application.service.ApplicationException;

public class UsuarioDuplicadoException extends ApplicationException {
    public UsuarioDuplicadoException(String message) {
        super(message);
    }
}
