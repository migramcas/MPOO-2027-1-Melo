package mx.unam.fi.melo.api.controllers.dashboard;

import mx.unam.fi.domain.model.Rol;
import mx.unam.fi.domain.model.Usuario;
import mx.unam.fi.melo.api.dto.inbound.NuevoUsuarioRequest;
import mx.unam.fi.melo.application.service.usuario.UsuarioCrudService;
import mx.unam.fi.melo.application.service.usuario.dto.InfoCrearUsuarioDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dashboard/administrador")
public class AdministradorManagementController {

    private final UsuarioCrudService usuarioCrudService;

    public AdministradorManagementController(UsuarioCrudService usuarioCrudService) {
        this.usuarioCrudService = usuarioCrudService;
    }

    @GetMapping
    public List<Usuario> getAll() {
        return usuarioCrudService.obtenerTodosUsuarios()
                .stream()
                .filter(usuario -> usuario.getRol().equals(Rol.ADMIN) || usuario.getRol().equals(Rol.SUPER_ADMIN))
                .toList();
    }

    @GetMapping("/{id}")
    public Usuario getById(@PathVariable Long id) {
        Usuario usuario = usuarioCrudService.obtenerUsuarioPorId(id)
                .orElseThrow(() -> new IllegalStateException("Usuario con id " + id + " no encontrado"));

        if(!usuario.getRol().equals(Rol.ADMIN)) {
            throw new IllegalStateException("El usuario con id " + id + " no es un administrador");
        }

        return usuario;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario create(@RequestBody NuevoUsuarioRequest request) {
        InfoCrearUsuarioDto dto = InfoCrearUsuarioDto.builder()
                .rol(Rol.ADMIN)
                .nombreUsuario(request.getNombreUsuario())
                .nombre(request.getNombre())
                .apellidoPaterno(request.getApellidoPaterno())
                .apellidoMaterno(request.getApellidoMaterno())
                .fechaNacimiento(request.getFechaNacimiento())
                .email(request.getEmail())

                .build();
        return usuarioCrudService.crear(dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        usuarioCrudService.eliminar(id, Rol.ADMIN);
    }
}
