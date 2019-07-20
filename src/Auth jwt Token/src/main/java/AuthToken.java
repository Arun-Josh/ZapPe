
import io.jsonwebtoken.*;

import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.impl.crypto.MacProvider;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.TemporalAmount;
import javax.crypto.SecretKey;

public class AuthToken {

    private static final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
    private static final SecretKey SECRET_KEY = MacProvider.generateKey(signatureAlgorithm);
    private static final TemporalAmount TOKEN_VALIDITY = Duration.ofHours(4L);

    public static String createJWT(String issuer, String user, String pass) {

        final Instant now = Instant.now();
        final Date expiryDate = Date.from(now.plus(TOKEN_VALIDITY));

        JwtBuilder builder = Jwts.builder()
//                .setId(id)
                .setIssuedAt(Date.from(now))
                .claim("user", user)
                .claim("pass", pass)
                .setIssuer(issuer)
                .setExpiration(expiryDate)
                .signWith(signatureAlgorithm, SECRET_KEY);

        return builder.compact();
    }

    public static Claims decodeJWT(String jwt) {

        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(jwt).getBody();

        return claims;
    }
}