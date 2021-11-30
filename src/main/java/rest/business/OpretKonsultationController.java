package rest.business;

import rest.Data.OpretKonsultation;
import rest.Data.OpretKonsultationDAO;

import javax.ws.rs.WebApplicationException;

public class OpretKonsultationController {
    private static OpretKonsultationDAO opretKonsultationDAO = new OpretKonsultationDAO();

    public void nyKonsultation(OpretKonsultation opretKonsultation) {
        OpretKonsultation consultation = opretKonsultationDAO.InsertIntoAftaler2(opretKonsultation.getCPR(), opretKonsultation.getTimeStart(), opretKonsultation.getTimeEnd(), opretKonsultation.getNotat(), opretKonsultation.getKlinikID());
        OpretKonsultation konsul = opretKonsultationDAO.InsertIntoAftaler(opretKonsultation);
        if (consultation != null) {
            System.out.println("consultation gik i stå i Controller");
        }
        if (konsul != null) {
            System.out.println("konsul gik i stå i Controller");
        }
        System.out.println("Vi er i controller");
        throw new WebApplicationException("Ikke godt", 401);
    }

    //public void doPost()
}