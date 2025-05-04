package demo.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ComentarioDTO {
    private Long idComentario;
    private String estado;
    private String contenido;
    private Date fechaComentario;
    private Long idUsuario;
    private String nombreUsuario;
    private Long idPublicacion;
}
