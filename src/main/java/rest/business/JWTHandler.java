package rest.business;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.WebApplicationException;
import java.security.Key;
import java.util.Calendar;

public class JWTHandler {
    private static Key key = MacProvider.generateKey(SignatureAlgorithm.HS512);

    public static String generateToken(String brugernavn) { // laver tokenen
        /*hvornår den udløber*/
        Calendar expiry = Calendar.getInstance();
        expiry.add(Calendar.MINUTE, 240); //dvs 4 timer
        return Jwts.builder() //bygger tokenen udfra brugernavn.
                .claim("User",brugernavn) //Genere en unik nøgle udfra brugernavnet
                .signWith(SignatureAlgorithm.HS512,key)
                .setExpiration(expiry.getTime()) //hvornår den udløber
                /*den gemmes*/
                .compact();
    }

    private static Key getKey(){
//Generate a secret key, if there is none specified in the environment - only use fixed key in development for debugging
        if (key==null) {
            if (System.getenv("JWT_SECRET_KEY")!= null && System.getenv("JWT_SECRET_KEY") != "") {
                String string = System.getenv("JWT_SECRET_KEY");
                key = new SecretKeySpec(string.getBytes(), 0, string.length(), "HS512");
            } else {
                key = MacProvider.generateKey(SignatureAlgorithm.HS512);
            }
        }
        return key;
    }

    public static String validateToken(String authHeader) { //den modtager den stringen der hedder validateToken fra PatientService klasse.
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(getKey()) // vi får key fra getKey
                    .parseClaimsJws(authHeader) // den kalder authHeader fra PatientService og
                    .getBody();
            String user = (String) claims.get("User"); //kan sette token tilbage til den oprindelige tekst.
            return user;
        } catch (JwtException e){
            throw new WebApplicationException(401);
        }

    }



   /* public static Bruger validerBruger(String authentication) {
        String[] tokenArray = authentication.split(" ");
        String token = tokenArray[tokenArray.length - 1];
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(getKey())
                    .parseClaimsJws(token)
                    .getBody();
            ObjectMapper mapper = new ObjectMapper();
            Bruger user = mapper.convertValue(claims.get("Users"), Bruger.class);
            System.out.println(Bruger);
            return Bruger;
        } catch (JwtException e){
            System.out.println(e.getClass() +":  "+ e.getMessage() );
            throw new NotAuthorizedException(e.getMessage());
        }
    }*/

}
/*Sikrer ikke at beskeden er hemmelig, men at ingen kan pille ved vores token og ændre i den*/
