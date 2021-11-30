package rest.api;

import rest.Data.OpretKonsultation;
import rest.Data.OpretKonsultationDAO;
import rest.business.JWTHandler;
import rest.business.OpretKonsultationController;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
//import java.sql.Connection;
//import java.sql.PreparedStatement;

@Path("opretKonsultation")
public class OpretKonsultationService {
    private OpretKonsultationController opretKonsultationController = new OpretKonsultationController();
    private OpretKonsultationDAO opretKonsultationDAO = new OpretKonsultationDAO();
    private OpretKonsultation opretKonsultation = new OpretKonsultation();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void nyKonsultation(@HeaderParam("authorization") String authHeader) {
        JWTHandler.validateToken(authHeader);
        opretKonsultationDAO.InsertIntoAftaler(opretKonsultation);
        opretKonsultationController.nyKonsultation(opretKonsultation);
        System.out.println("den er nået til OpretKonsultationService");
        //System.out.println(opretKonsultationController.nyKonsultation(opretKonsultation));
    }
    /*
    public void postKonsultation(HttpServletRequest request, HttpServletResponse response) {

        try {
            Connection con = MySQLDB.getConnection();

            PreparedStatement st = con.prepareStatement("INSERT INTO Aftaler (CPR, TimeStart, TimeEnd, Notat, KlinikID) VALUES (?,?,?,?,?)");
            st.setString(1, request.getParameter("CPR"));
            st.setString(2, request.getParameter("TimeStart"));
            st.setString(2, request.getParameter("TimeEnd"));
            st.setString(2, request.getParameter("Notat"));
            st.setString(2, request.getParameter("KlinikID"));

            st.executeUpdate();

            // Close all the connections
            st.close();
            con.close();

            System.out.println("indsat med doPost metode i db");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */

    //OpretKonsultationDAO(OpretKonsultationer opretKonsultationer){
    //opretKonsultationDAO.InsertIntoAftaler(opretKonsultationer);
}

