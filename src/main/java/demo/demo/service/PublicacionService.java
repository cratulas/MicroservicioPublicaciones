package demo.demo.service;

import demo.demo.model.Publicacion;
import demo.demo.repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicacionService {

    @Autowired
    private PublicacionRepository publicacionRepository;

    public List<Publicacion> obtenerTodasLasPublicaciones() {
        return publicacionRepository.findByEstado("activo");
    }

    public List<Publicacion> obtenerPublicacionesPorEstado(String estado) {
        return publicacionRepository.findByEstado(estado);
    }
    
    
    public Optional<Publicacion> obtenerPublicacionPorId(Long id) {
        return publicacionRepository.findById(id);
    }

    public List<Publicacion> buscarPublicacionesPorTitulo(String titulo) {
        return publicacionRepository.findByTituloContainingIgnoreCaseAndEstado(titulo, "activo");
    }

    public Publicacion crearPublicacion(Publicacion publicacion) {
        return publicacionRepository.save(publicacion);
    }
    
    public Publicacion actualizarPublicacion(Long id, Publicacion publicacionActualizada) {
        return publicacionRepository.findById(id)
                .map(publicacion -> {
                    publicacion.setTitulo(publicacionActualizada.getTitulo());
                    publicacion.setContenido(publicacionActualizada.getContenido());
                    return publicacionRepository.save(publicacion);
                })
                .orElseThrow(() -> new RuntimeException("Publicación no encontrada"));
    }

    public Publicacion cambiarEstadoPublicacion(Long id, String nuevoEstado) {
        return publicacionRepository.findById(id)
                .map(publicacion -> {
                    publicacion.setEstado(nuevoEstado);
                    return publicacionRepository.save(publicacion);
                })
                .orElseThrow(() -> new RuntimeException("Publicación no encontrada"));
    }
}
