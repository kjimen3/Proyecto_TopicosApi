package registro.topicos.api.domain.topico;

import registro.topicos.api.domain.usuario.DatosUsuario;

public record DatosRespuestaTopico(Long id, String titulo, String mensaje, String fecha_de_creacion, String status, DatosUsuario usuario, String curso) {
}
