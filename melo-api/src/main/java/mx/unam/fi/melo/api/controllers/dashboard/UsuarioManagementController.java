package mx.unam.fi.melo.api.controllers.dashboard;

import java.util.List;

import mx.unam.fi.domain.model.Rol;
import mx.unam.fi.melo.api.dto.inbound.ActualizarUsuarioRequest;
import mx.unam.fi.melo.api.dto.inbound.NuevoUsuarioRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import mx.unam.fi.domain.model.Usuario;
import mx.unam.fi.melo.application.service.usuario.UsuarioCrudService;
import mx.unam.fi.melo.application.service.usuario.dto.ActualizarUsuarioDto;
import mx.unam.fi.melo.application.service.usuario.dto.InfoCrearUsuarioDto;

@RestController
@RequestMapping("/dashboard/usuario")
public class UsuarioManagementController {

    private final UsuarioCrudService usuarioCrudService;

    public UsuarioManagementController(UsuarioCrudService usuarioCrudService) {
        this.usuarioCrudService = usuarioCrudService;
    }

    @GetMapping
    public List<Usuario> getAll() {
        return usuarioCrudService.obtenerTodosUsuarios()
                .stream()
                .filter(usuario -> usuario.getRol().equals(Rol.USUARIO))
                .toList();
    }

    @GetMapping("/{id}")
    public Usuario getById(@PathVariable Long id) {
        Usuario usuario = usuarioCrudService.obtenerUsuarioPorId(id)
                .orElseThrow(() -> new IllegalStateException("Usuario con id " + id + " no encontrado"));

        if(!usuario.getRol().equals(Rol.USUARIO)) {
            throw new IllegalStateException("El usuario con id " + id + " no puede ser consultado");
        }

        return usuario;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        usuarioCrudService.eliminar(id, Rol.USUARIO);
    }
}
