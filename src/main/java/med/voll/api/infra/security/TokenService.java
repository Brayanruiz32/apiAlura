package med.voll.api.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import med.voll.api.domain.usuario.Usuario;

@Service
public class TokenService {
    
    @Value("${api.security.secret}")
    private String apiSecret;// instanciacion de una api Secret

    public String generarToken(Usuario user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("apiMed")
                    .withSubject(user.getLogin())
                    .withClaim("id", user.getId())
                    .withExpiresAt(generarFechaExpiracion())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException();
        }

    }
    //esto es para verificar la validez del tokem, si aún sirve para el usuario
    public String getSubject(String token) {
       
        DecodedJWT verifier;
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
             verifier = JWT.require(algorithm)
                    .withIssuer("apiMed")
                    .build()
                    .verify(token);
                    verifier.getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException();
        }
        if (verifier.getSubject() == null) {
            throw new RuntimeException("Verifier invalido");
        }
        return verifier.getSubject();
    }

    private Instant generarFechaExpiracion() {
        return LocalDateTime.now().plusHours(12).toInstant(ZoneOffset.of("-05:00"));
    }

}
