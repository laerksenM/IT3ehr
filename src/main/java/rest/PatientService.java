package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("patients")
public class PatientService {
    //GET Bruges når noget skal læses
    @GET
    //Produces efterfølges af noget der sendes tilbage
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bruger> getPatients() {
        return null;
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


