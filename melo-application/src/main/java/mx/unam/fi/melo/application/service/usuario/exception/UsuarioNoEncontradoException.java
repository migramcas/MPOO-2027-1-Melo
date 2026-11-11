package mx.unam.fi.melo.application.service.usuario.exception;

import mx.unam.fi.melo.application.service.ApplicationException;

public class UsuarioNoEncontradoException extends ApplicationException {

    public UsuarioNoEncontradoException(String message) {
        super(message);
    }

}
