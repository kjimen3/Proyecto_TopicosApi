package registro.topicos.api.domain.topico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import registro.topicos.api.domain.usuario.DatosUsuario;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
        String fecha_de_creacion,
        @NotNull
        Status status,
        @NotNull
        @Valid
        DatosUsuario usuario,
        @NotBlank
        String curso) {
}
