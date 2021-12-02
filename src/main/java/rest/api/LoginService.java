package rest.api;

import rest.Data.Bruger;
import rest.business.LoginController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//Path bruges til at finde vej fra js til java.
@Path("login") //gør at den bliver samlet op af tomcat og bliver brugt fornuftigt.
public class LoginService {
    private static LoginController loginController = new LoginController(); //skaber forbindelse til LoginController klasse


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String validerBruger(Bruger bruger) {
        return loginController.validerBruger(bruger);
    }
}

