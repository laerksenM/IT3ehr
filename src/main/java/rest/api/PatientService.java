package rest.api;


import rest.Data.Bruger;
import rest.Data.Patient;
import rest.business.JWTHandler;
import rest.Data.BrugerDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


@Path("patients")
public class PatientService {
    @GET
    //Produces efterfølges af noget der sendes tilbage
    @Produces({MediaType.APPLICATION_JSON})
    //@Consumes({MediaType.APPLICATION_JSON})
    //public List<Patient> getGiraffes() {
    //    return PatientDao.getInstance().getGiraffes();
    //}
    public List<Bruger> getPatient(@HeaderParam("authorization") String authHeader) { //vi laver en header, hvor token kan validere den.
        System.out.println("authHeader: "+authHeader);
        JWTHandler.validateToken(authHeader); //valideret en token.
        return BrugerDAO.allPatients();//GET Bruges når noget skal læses
    /*@GET
    //Produces efterfølges af noget der sendes tilbage
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bruger> getPatients(@HeaderParam("authorization") String authHeader) { //vi laver en header, hvor token kan validere den.
        System.out.println("authHeader: "+authHeader);
        JWTHandler.validateToken(authHeader); //valideret en token.
        //FIXME: Find actual patients!
        List<Bruger> brugers = new ArrayList<>(); // detter er blot en tester
        Bruger testBruger = new Bruger(); //tester
        testBruger.setBrugernavn("johnny"); //tester
        brugers.add(testBruger); //tester
        return brugers;
       // return BrugerDAO.getInstance().getPatients();
    }*/
    }
    /*
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Bruger postPatient(Bruger b) {
        System.out.println("Bruger: " + b);
        BrugerDAO.getInstance().getPatient().add(b);
        BrugerDAO.getInstance().savePatient(b);
        System.out.println("Successfully added Bruger: " + b);
        return b;
    }*/
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Bruger postPatient(Bruger b) {
        System.out.println("Bruger: " + b);
        BrugerDAO.getInstance().getPatient().add(b);
        BrugerDAO.getInstance().savePatient(b);
        System.out.println("Successfully added Bruger: " + b);
        return b;
    }

}


