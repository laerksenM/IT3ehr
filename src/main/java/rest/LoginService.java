package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.*;

@Path("login") //gør at den bliver samlet op af tomcat og bliver brugt fornuftigt.
public class LoginService {
    private static LoginController loginController = new LoginController();


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String validerBruger(Bruger bruger) {
        return loginController.validerBruger(bruger);
    }
}
/*
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String validerBruger(@PathParam("Brugernavn") String brugernavn, @PathParam("password") String password) {
        System.out.println("Når her til :) ");
        System.out.println(brugernavn);
        Connection con = MySQLDB.getConnection();

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Users");

            while (rs.next()) {
                if (brugernavn.equals(rs.getString(2)) && password.equals(rs.getString(3)))
                    return "ok";

                System.out.println(rs.getString(1) + " " + rs.getString(2));
                System.out.println("----------------------");
            }

            return "not ok";
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "Looger ind";
    }
}
*/
