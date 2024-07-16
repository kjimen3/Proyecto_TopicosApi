package registro.topicos.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import registro.topicos.api.domain.usuariosAutorization.DatosAutenticacionUser;
import registro.topicos.api.domain.usuariosAutorization.User;
import registro.topicos.api.infra.security.DatosJWTToken;
import registro.topicos.api.infra.security.TokenService;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity autenticarUser(@RequestBody @Valid DatosAutenticacionUser datosAutenticacionUser) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUser.login(),
                datosAutenticacionUser.clave());
        var ususarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((User) ususarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
    }
}
