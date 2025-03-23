package demo.demo.controller;

import demo.demo.model.Comentario;
import demo.demo.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    // Listar comentarios por publicación
    @GetMapping("/publicacion/{idPublicacion}")
    public List<Comentario> listarComentariosPorPublicacion(@PathVariable Long idPublicacion) {
        return comentarioService.obtenerComentariosPorPublicacion(idPublicacion);
    }

    // Crear nuevo comentario
    @PostMapping
    public Comentario crearComentario(@RequestBody Comentario comentario) {
        return comentarioService.crearComentario(comentario);
    }
}
