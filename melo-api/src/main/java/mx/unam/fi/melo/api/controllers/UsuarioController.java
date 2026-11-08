package mx.unam.fi.melo.api.controllers;

import java.util.List;

import mx.unam.fi.melo.api.dto.inbound.AltaUsuarioDto;
import mx.unam.fi.melo.application.service.usuario.dto.NuevoUsuarioDto;
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

    @PostMapping
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

}
