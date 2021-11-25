package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("test")
public class TestService {
    @GET
    public String getTest(){
        return "test klaret";
    }
}
