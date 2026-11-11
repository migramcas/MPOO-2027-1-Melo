package mx.unam.fi.melo.api.controllers.dashboard;

import mx.unam.fi.domain.model.Cancion;
import mx.unam.fi.melo.api.dto.inbound.ActualizarCancionRequest;
import mx.unam.fi.melo.api.dto.inbound.NuevaCancionRequest;
import mx.unam.fi.melo.application.service.cancion.CancionCrudService;
import mx.unam.fi.melo.application.service.cancion.dto.ActualizarCancionDto;
import mx.unam.fi.melo.application.service.cancion.dto.CrearCancionDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dashboard/cancion")
public class CancionManagementController {

    private final CancionCrudService cancionCrudService;

    public CancionManagementController(CancionCrudService cancionCrudService) {
        this.cancionCrudService = cancionCrudService;
    }

    @GetMapping
    public List<Cancion> getAll() {
        return cancionCrudService.obtenerTodos();
    }

    // endpoint => https://localhost:8080/dashboard/cancion/1000000
    @GetMapping("/{id}")
    public Cancion getById(@PathVariable Long id) {
        return cancionCrudService.obtenerPorId(id)
                .orElseThrow(() -> new IllegalStateException("Canción no encontrada"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cancion create(@RequestBody NuevaCancionRequest request) {
        CrearCancionDto dto = CrearCancionDto.builder()
                .titulo(request.getTitulo())
                .url(request.getUrl())
                .duracion(request.getDuracion())
                .genero(request.getGenero())
                .numeroPista(request.getNumeroPista())
                .build();
        return cancionCrudService.crear(dto);
    }

    @PutMapping("/{id}")
    public Cancion update(@PathVariable Long id, @RequestBody ActualizarCancionRequest request) {
        ActualizarCancionDto dto = ActualizarCancionDto.builder()
                .titulo(request.getTitulo())
                .url(request.getUrl())
                .duracion(request.getDuracion())
                .genero(request.getGenero())
                .numeroPista(request.getNumeroPista())
                .build();
        return cancionCrudService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        cancionCrudService.eliminar(id);
    }
}
