package mx.unam.fi.melo.api.controllers;

import mx.unam.fi.domain.model.Artista;
import mx.unam.fi.melo.application.service.artista.ArtistaCrudService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artista")
public class ArtistaController {

    private final ArtistaCrudService artistaCrudService;

    public ArtistaController(ArtistaCrudService artistaCrudService) {
        this.artistaCrudService = artistaCrudService;
    }

    @GetMapping()
    public List<Artista> getAllArtistas() {
        return artistaCrudService.getAll();
    }

}