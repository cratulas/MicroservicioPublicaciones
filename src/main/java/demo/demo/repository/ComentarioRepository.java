package demo.demo.repository;

import demo.demo.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    List<Comentario> findByPublicacionIdPublicacion(Long idPublicacion);
    List<Comentario> findByPublicacionIdPublicacionAndEstado(Long idPublicacion, String estado);
    List<Comentario> findByEstado(String estado);
}
