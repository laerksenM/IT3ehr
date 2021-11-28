package rest;

import javax.ws.rs.WebApplicationException;

public class KonsultationController {
    private static KonsultationDao konsultationDao = new KonsultationDao();

    public Konsultationer hentKonsultationer(String cprNummer) {

        System.out.println("kommer her");
        System.out.println(cprNummer);
        Konsultationer aftale = konsultationDao.findKonsultationer(cprNummer);
        System.out.println(cprNummer);

        return aftale;
//        return JWTHandler.generateToken(aftale.getCPR());

    }
}
