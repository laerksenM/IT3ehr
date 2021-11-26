package rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class LoginData {
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public class LoginService {

        @POST
        public String postLoginData(LoginData login){
            return null;
        }

    }/*
     if (user !=null && user.getPassword().equals(user.getPassword())) {
        return JWTHandler.generateToken(user.getBrugernavn());
        */
        }
