package demo.demo.repository;

import demo.demo.model.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {
    List<Publicacion> findByTituloContainingIgnoreCase(String titulo);
    List<Publicacion> findByEstado(String estado);
    List<Publicacion> findByTituloContainingIgnoreCaseAndEstado(String titulo, String estado);
}
