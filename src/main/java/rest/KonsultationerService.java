package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("konsultationer")
public class KonsultationerService {
    private static KonsultationController konsultationController = new KonsultationController();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Konsultationer hentKonsultationer(@QueryParam("cpr_nummer") String cprNummer) {
        return konsultationController.hentKonsultationer(cprNummer);
    }
}
    /*
    //GET Bruges når noget skal læses
    @GET
    //Produces efterfølges af noget der sendes tilbage
    @Produces(MediaType.APPLICATION_JSON)
    public List<Konsultationer> getKonsultationer(@HeaderParam("authorization") String authHeader) { //vi laver en header, hvor token kan validere den.
        System.out.println(authHeader);
        JWTHandler.validateToken(authHeader); //valideret en token.
        //FIXME: Find actual patients!
        List<Konsultationer> aftaler = new ArrayList<>(); // dette er blot en tester
        Konsultationer testKonsultation = new Konsultationer(); //tester
        testKonsultation.setCPR("55555"); //tester
        aftaler.add(testKonsultation); //tester
        return aftaler;
        // return BrugerDAO.getInstance().getPatients();
    }
    }*/