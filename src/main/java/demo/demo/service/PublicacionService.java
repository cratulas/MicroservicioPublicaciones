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
    

    public Optional<Publicacion> obtenerPublicacionPorId(Long id) {
        return publicacionRepository.findById(id);
    }

    public List<Publicacion> buscarPublicacionesPorTitulo(String titulo) {
        return publicacionRepository.findByTituloContainingIgnoreCase(titulo);
    }

    public Publicacion crearPublicacion(Publicacion publicacion) {
        return publicacionRepository.save(publicacion);
    }
}
