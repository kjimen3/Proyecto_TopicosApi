package registro.topicos.api.domain.topico;

import jakarta.validation.constraints.NotNull;
import registro.topicos.api.domain.usuario.DatosUsuario;

public record DatosActualizarTopico(
    @NotNull
    Long id,
    String titulo,
    String mensaje,
    DatosUsuario usuario,
    String curso){
}
