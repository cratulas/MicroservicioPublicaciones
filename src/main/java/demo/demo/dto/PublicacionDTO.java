package demo.demo.dto;

import demo.demo.model.Categoria;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PublicacionDTO {
    private Long idPublicacion;
    private String estado;
    private String titulo;
    private String contenido;
    private Date fechaPublicacion;
    private Long idUsuario;
    private String nombreUsuario;
    private Categoria categoria;
}
