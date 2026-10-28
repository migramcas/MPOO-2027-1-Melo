package mx.unam.fi.melo.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
