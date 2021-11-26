package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


@Path("patients")
public class PatientService {
    //GET Bruges når noget skal læses
    @GET
    //Produces efterfølges af noget der sendes tilbage
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bruger> getPatients(@HeaderParam("authorization") String authHeader) {
        System.out.println(authHeader);
        JWTHandler.validateToken(authHeader);
        //FIXME: Find actual patients!
        List<Bruger> brugers = new ArrayList<>();
        Bruger testBruger = new Bruger();
        testBruger.setBrugernavn("johnny");
        brugers.add(testBruger);
        return brugers;
       // return BrugerDAO.getInstance().getPatients();
    }
/*
    @GET
    @Path("{cpr}")
    public Bruger getPatient(@PathParam("cpr") String cpr) {
        return null;
    }

    //POST bruges når der skal tilføjes en ressource, feks en ny pt skal oprettes
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Bruger postPatient(Bruger p) {
        PatientDao.getInstance().getPatients().add(p);
        return p;

    }

 */
}


