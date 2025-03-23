package demo.demo.controller;

import demo.demo.model.Publicacion;
import demo.demo.service.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publicaciones")
public class PublicacionController {

    @Autowired
    private PublicacionService publicacionService;

    // Obtener todas las publicaciones
    @GetMapping
    public List<Publicacion> listarPublicaciones() {
        return publicacionService.obtenerTodasLasPublicaciones();
    }

    // Buscar publicaciones por título
    @GetMapping("/buscar")
    public List<Publicacion> buscarPorTitulo(@RequestParam String titulo) {
        return publicacionService.buscarPublicacionesPorTitulo(titulo);
    }

    // Obtener publicación por ID
    @GetMapping("/{id}")
    public ResponseEntity<Publicacion> obtenerPorId(@PathVariable Long id) {
        return publicacionService.obtenerPublicacionPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear nueva publicación
    @PostMapping
    public Publicacion crearPublicacion(@RequestBody Publicacion publicacion) {
        return publicacionService.crearPublicacion(publicacion);
    }
}
