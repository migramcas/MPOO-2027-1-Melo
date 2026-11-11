package mx.unam.fi.melo.api.controllers.app;

import mx.unam.fi.domain.model.Cancion;
import mx.unam.fi.melo.application.service.cancion.CancionCrudService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/cancion")
public class CancionAppController {

    private final CancionCrudService cancionCrudService;

    public CancionAppController(CancionCrudService cancionCrudService) {
        this.cancionCrudService = cancionCrudService;
    }

    @GetMapping
    public List<Cancion> getAll() {
        return cancionCrudService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Cancion getById(@PathVariable Long id) {
        return cancionCrudService.obtenerPorId(id)
                .orElseThrow(() -> new IllegalStateException("Canción no encontrada"));
    }
}
