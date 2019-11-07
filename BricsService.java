package cgg.gov.in.rest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

 
public class BricsService {
	
	 BricsDAO dao=new BricsDAO();
	 
	 
	 public List<Brics> getAllUsers(){
		 
		 List<Brics> BricsList=dao.getAllUsers();
	  
		 return BricsList;
	}
	 
	  public  Brics getBric(String mobileNo) {
		  
		  Brics bric=dao.getBric(mobileNo);
	  
		  return bric;
	    }
	  
	 

	    public  Brics addCustomer(Brics bric) {
	    	Brics bricresponse=dao.addCustomer(bric);
	        return bricresponse;
	    }
	    
	    public  Brics updateCustomer(Brics bric) {
	    	Brics bricresponse=dao.updateBric(bric);
	        return bricresponse;
	    }
	    
	    public Brics deleteBric(String  mobile){
	    	
	    	Brics bricresponse=dao.deleteUser(mobile);
	    	return bricresponse;
	    }
}
