package mx.unam.fi.melo.api.controllers;

import java.util.List;

import mx.unam.fi.melo.api.dto.inbound.AltaUsuarioDto;
import mx.unam.fi.melo.application.service.usuario.dto.ActualizarUsuarioDto;
import mx.unam.fi.melo.application.service.usuario.dto.NuevoUsuarioDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import mx.unam.fi.domain.model.Usuario;
import mx.unam.fi.melo.application.service.usuario.UsuarioCrudService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioCrudService usuarioCrudService;

    public UsuarioController(UsuarioCrudService usuarioCrudService) {
        this.usuarioCrudService = usuarioCrudService;
    }

    @GetMapping()
    public List<Usuario> getAllUsuarios() {
        return usuarioCrudService.obtenerTodosUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable("id") Long id) {
        return usuarioCrudService.obtenerUsuarioPorId(id)
                .orElseThrow(() -> new IllegalStateException("Usuario con id " + id + " no encontrado"));
    }

    @GetMapping("/email/{email}")
    public Usuario getUsuarioByEmail(@PathVariable("email") String email) {
        return usuarioCrudService.obtenerUsuarioPorEmail(email)
                .orElseThrow(() -> new IllegalStateException("Usuario con email " + email + " no encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario crearUsuario(@RequestBody AltaUsuarioDto usuarioInput) {

        NuevoUsuarioDto nuevoUsuario = NuevoUsuarioDto.builder()
                .nombreUsuario(usuarioInput.getNombreUsuario())
                .nombre(usuarioInput.getNombre())
                .apellidoPaterno(usuarioInput.getApellidoPaterno())
                .apellidoMaterno(usuarioInput.getApellidoMaterno())
                .fechaNacimiento(usuarioInput.getFechaNacimiento())
                .email(usuarioInput.getEmail())
                .build();

        return usuarioCrudService.crear(nuevoUsuario);
    }

    @PutMapping("/{id}")
    public Usuario actualizarUsuario(
            @PathVariable("id") Long id,
            @RequestBody ActualizarUsuarioDto usuarioInput
    ) {
        return usuarioCrudService.actualizar(id, usuarioInput);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarUsuario(@PathVariable("id") Long id) {
        usuarioCrudService.eliminar(id);
    }

}
