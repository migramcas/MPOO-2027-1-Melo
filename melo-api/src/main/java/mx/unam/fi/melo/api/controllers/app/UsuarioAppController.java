package mx.unam.fi.melo.api.controllers.app;

import mx.unam.fi.domain.model.Rol;
import mx.unam.fi.domain.model.Usuario;
import mx.unam.fi.melo.api.dto.inbound.NuevoUsuarioRequest;
import mx.unam.fi.melo.application.service.usuario.UsuarioCrudService;
import mx.unam.fi.melo.application.service.usuario.dto.InfoCrearUsuarioDto;
import mx.unam.fi.melo.application.service.usuario.exception.UsuarioDuplicadoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/usuario")
public class UsuarioAppController {

    private final UsuarioCrudService usuarioCrudService;

    public UsuarioAppController(UsuarioCrudService usuarioCrudService) {
        this.usuarioCrudService = usuarioCrudService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario create(@RequestBody NuevoUsuarioRequest request) throws UsuarioDuplicadoException {
        InfoCrearUsuarioDto dto = InfoCrearUsuarioDto.builder()
                .rol(Rol.USUARIO)
                .nombreUsuario(request.getNombreUsuario())
                .nombre(request.getNombre())
                .apellidoPaterno(request.getApellidoPaterno())
                .apellidoMaterno(request.getApellidoMaterno())
                .fechaNacimiento(request.getFechaNacimiento())
                .email(request.getEmail())
                .creadoPor(0L) // TODO ésto se moverá a parte de la autenticación y proceso de creación de usuario
                .build();
        return usuarioCrudService.crear(dto);
    }
}
