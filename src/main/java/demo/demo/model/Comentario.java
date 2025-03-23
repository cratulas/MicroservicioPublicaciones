package demo.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "comentarios")
@Getter
@Setter
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comentario")
    private Long idComentario;

    @NotBlank(message = "El contenido del comentario es obligatorio")
    @Lob
    private String contenido;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_comentario")
    private Date fechaComentario = new Date();

    @Column(name = "id_usuario")
    private Long idUsuario;

    @ManyToOne
    @JoinColumn(name = "id_publicacion")
    private Publicacion publicacion;
}
