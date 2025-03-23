package demo.demo.service;

import demo.demo.model.Comentario;
import demo.demo.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    public List<Comentario> obtenerComentariosPorPublicacion(Long idPublicacion) {
        return comentarioRepository.findByPublicacionIdPublicacion(idPublicacion);
    }

    public Comentario crearComentario(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }
}
