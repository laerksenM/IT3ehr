package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.*;

@Path("konsultation")
public class KonsultationerService {
    private static LoginController loginController = new LoginController();


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String validerBruger(Bruger bruger) {
        return loginController.validerBruger(bruger);
    }
}

