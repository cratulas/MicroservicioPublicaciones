package demo.demo.controller;

import demo.demo.model.Comentario;
import demo.demo.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;


    @GetMapping("/publicacion/{idPublicacion}")
    public List<Comentario> listarComentariosPorPublicacion(
            @PathVariable Long idPublicacion,
            @RequestParam(required = false) String estado
    ) {
        if (estado != null) {
            return comentarioService.obtenerComentariosPorPublicacionYEstado(idPublicacion, estado);
        } else {
            return comentarioService.obtenerComentariosPorPublicacion(idPublicacion);
        }
    }


    @PostMapping
    public Comentario crearComentario(@RequestBody Comentario comentario) {
        return comentarioService.crearComentario(comentario);
    }


    @PutMapping("/{id}")
    public Comentario actualizarComentario(@PathVariable Long id, @RequestBody Comentario comentario) {
        return comentarioService.actualizarComentario(id, comentario);
    }


    @PutMapping("/{id}/estado")
    public ResponseEntity<Comentario> cambiarEstadoComentario(@PathVariable Long id, @RequestParam String estado) {
        return comentarioService.obtenerComentarioPorId(id)
                .map(comentario -> {
                    comentario.setEstado(estado);
                    Comentario actualizado = comentarioService.actualizarComentario(comentario);
                    return ResponseEntity.ok(actualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Comentario> listarTodosLosComentarios() {
        return comentarioService.listarTodosLosComentarios();
    }

    @GetMapping("/estado")
    public List<Comentario> listarComentariosPorEstado(@RequestParam String estado) {
        return comentarioService.obtenerComentariosPorEstado(estado);
    }
}
