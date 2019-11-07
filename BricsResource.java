package cgg.gov.in.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/bricInfo")
public class BricsResource {
	
	BricsService bricservice= new BricsService();
	 
@POST
//@Produces(MediaType.APPLICATION_JSON)
@Produces("application/json")
@Consumes("application/json")
//@Consumes(MediaType.APPLICATION_JSON)

public Brics createUser(Brics bric) {
	
			Brics userResponse = bricservice.addCustomer(bric);
			
return userResponse;
}
	 
// CRUD -- READ operation
 @GET
 @Produces("application/json")
 @Consumes("application/json")
 public List<Brics> getAllUsers() {
 List<Brics> userList = bricservice.getAllUsers();
return userList;
}
	 
 
 @GET
@Path("/{id}")
 @Produces("application/json")
 @Consumes("application/json")
public Brics getUserForId(@PathParam("id") String mobileNo) {
Brics user = bricservice.getBric(mobileNo);
return user;
}
	  
@PUT
@Produces("application/json")
@Consumes("application/json")
public Brics updateBric(Brics bric) {
Brics userResponse = bricservice.updateCustomer(bric);
return userResponse;
}
	 
@DELETE
@Path("/{id}")
@Produces("application/json")
@Consumes("application/json")
public Brics deleteBric(@PathParam("id") String mobile) {
Brics userResponse = bricservice.deleteBric(mobile);
return userResponse;
}
}

	 
 