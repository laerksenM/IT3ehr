package rest.business;
import rest.Data.Bruger;
import rest.Data.BrugerDAO;

import javax.ws.rs.WebApplicationException;

public class LoginController {
    private static BrugerDAO brugerDAO = new BrugerDAO();
    public String validerBruger(Bruger bruger) {
        Bruger user = brugerDAO.findBruger(bruger.getBrugernavn());
        if (user !=null && user.getPassword().equals(user.getPassword())) {
            return JWTHandler.generateToken(user.getBrugernavn());
        }
        else {
            System.out.println("Brugernavn ikke finds:" + bruger.getBrugernavn());
        }
        throw new WebApplicationException("Ikke godt",401);
    }
}