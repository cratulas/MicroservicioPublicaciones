package demo.demo.service;

import demo.demo.model.Comentario;
import demo.demo.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    public List<Comentario> obtenerComentariosPorPublicacion(Long idPublicacion) {
        return comentarioRepository.findByPublicacionIdPublicacion(idPublicacion); 
    }
    
    

    public List<Comentario> obtenerComentariosPorPublicacionYEstado(Long idPublicacion, String estado) {
        return comentarioRepository.findByPublicacionIdPublicacionAndEstado(idPublicacion, estado);
    }

    public Comentario crearComentario(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    public Optional<Comentario> obtenerComentarioPorId(Long id) {
        return comentarioRepository.findById(id);
    }

    public Comentario actualizarComentario(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    public Comentario actualizarComentario(Long id, Comentario comentarioActualizado) {
        return comentarioRepository.findById(id)
                .map(comentario -> {
                    comentario.setContenido(comentarioActualizado.getContenido());
                    return comentarioRepository.save(comentario);
                })
                .orElseThrow(() -> new RuntimeException("Comentario no encontrado"));
    }

    public Comentario cambiarEstadoComentario(Long id, String nuevoEstado) {
        return comentarioRepository.findById(id)
                .map(comentario -> {
                    comentario.setEstado(nuevoEstado);
                    return comentarioRepository.save(comentario);
                })
                .orElseThrow(() -> new RuntimeException("Comentario no encontrado"));
    }

    public List<Comentario> listarTodosLosComentarios() {
        return comentarioRepository.findAll();
    }

    public List<Comentario> obtenerComentariosPorEstado(String estado) {
        return comentarioRepository.findByEstado(estado);
    }
}
