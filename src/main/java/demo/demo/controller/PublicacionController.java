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
    
    @GetMapping
    public List<Publicacion> listarPublicaciones(@RequestParam(required = false) String estado) {
        if (estado != null) {
            return publicacionService.obtenerPublicacionesPorEstado(estado);
        } else {
            return publicacionService.obtenerTodasLasPublicaciones();
        }
}

    @GetMapping("/buscar")
    public List<Publicacion> buscarPorTitulo(@RequestParam String titulo) {
        return publicacionService.buscarPublicacionesPorTitulo(titulo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publicacion> obtenerPorId(@PathVariable Long id) {
        return publicacionService.obtenerPublicacionPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Publicacion crearPublicacion(@RequestBody Publicacion publicacion) {
        return publicacionService.crearPublicacion(publicacion);
    }

    @PutMapping("/{id}")
    public Publicacion actualizarPublicacion(@PathVariable Long id, @RequestBody Publicacion publicacion) {
        return publicacionService.actualizarPublicacion(id, publicacion);
    }

    @PatchMapping("/{id}/estado")
    public Publicacion cambiarEstadoPublicacion(@PathVariable Long id, @RequestParam String estado) {
        return publicacionService.cambiarEstadoPublicacion(id, estado);
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<Publicacion> cambiarEstado(@PathVariable Long id, @RequestParam String estado) {
        return publicacionService.obtenerPublicacionPorId(id)
                .map(publicacion -> {
                    publicacion.setEstado(estado);
                    Publicacion actualizada = publicacionService.crearPublicacion(publicacion);
                    return ResponseEntity.ok(actualizada);
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
