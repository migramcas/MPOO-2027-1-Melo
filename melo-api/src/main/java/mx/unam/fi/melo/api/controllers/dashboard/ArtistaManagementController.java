package mx.unam.fi.melo.api.controllers.dashboard;

import mx.unam.fi.domain.model.Artista;
import mx.unam.fi.domain.model.ArtistaId;
import mx.unam.fi.melo.api.dto.inbound.ActualizarArtistaRequest;
import mx.unam.fi.melo.api.dto.inbound.NuevoArtistaRequest;
import mx.unam.fi.melo.application.service.artista.ArtistaCrudService;
import mx.unam.fi.melo.application.service.artista.dto.ActualizarArtistaDto;
import mx.unam.fi.melo.application.service.artista.dto.CrearArtistaDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dashboard/artista")
public class ArtistaManagementController {

    private final ArtistaCrudService artistaCrudService;

    public ArtistaManagementController(ArtistaCrudService artistaCrudService) {
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Artista create(@RequestBody NuevoArtistaRequest request) {
        CrearArtistaDto dto = CrearArtistaDto.builder()
                .nombreArtistico(request.getNombreArtistico())
                .biografia(request.getBiografia())
                .datosPersonales(request.getDatosPersonales())
                .generos(request.getGeneros())
                .build();
        return artistaCrudService.crear(dto);
    }

    @PutMapping("/{id}")
    public Artista update(@PathVariable Long id, @RequestBody ActualizarArtistaRequest request) {
        ActualizarArtistaDto dto = ActualizarArtistaDto.builder()
                .nombreArtistico(request.getNombreArtistico())
                .biografia(request.getBiografia())
                .generos(request.getGeneros())
                .build();
        return artistaCrudService.actualizar(ArtistaId.of(id), dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        artistaCrudService.eliminar(ArtistaId.of(id));
    }
}
