package mx.unam.fi.melo.api.controllers.app;

import mx.unam.fi.domain.model.Artista;
import mx.unam.fi.domain.model.ArtistaId;
import mx.unam.fi.melo.application.service.artista.ArtistaCrudService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/artista")
public class ArtistaAppController {

    private final ArtistaCrudService artistaCrudService;

    public ArtistaAppController(ArtistaCrudService artistaCrudService) {
        this.artistaCrudService = artistaCrudService;
    }

    @GetMapping
    public List<Artista> getAll() {
        return artistaCrudService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Artista getById(@PathVariable Long id) {
        return artistaCrudService.obtenerPorId(ArtistaId.of(id))
                .orElseThrow(() -> new IllegalStateException("Artista no encontrado"));
    }
}
