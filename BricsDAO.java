package cgg.gov.in.rest;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.jersey.spi.resource.Singleton;

@Singleton
public class BricsDAO {
	  private static final Map<String, Brics> bricsMap = new HashMap<String, Brics>();
	  
	   
	/*  public BricsDAO(){
	  Brics user1 = new Brics();
     
	  user1.setMobileNo("9030753607");
      user1.setCustName("rohinikumar");
      user1.setNo_of_Brics("10");
      user1.setAddress("Hyd");
     
      Brics user21 = new Brics();
      
      user21.setMobileNo("9030753607");
      user21.setCustName("rohinikumar");
      user21.setNo_of_Brics("10");
      user21.setAddress("Hyd");
     
      bricsMap.put("1", user1);
      bricsMap.put("2", user21);
	  }*/
	  public List<Brics> getAllUsers() {
		  
	        List<Brics> bricList = new ArrayList<Brics>(bricsMap.values());
	        return bricList;
	    }
	    public static Brics getBric(String mobileNo) {
	        return bricsMap.get(mobileNo);
	    }
	 
	    public static Brics addCustomer(Brics bric) {
	    	bricsMap.put(bric.getMobileNo(),bric);
	        return bric;
	    }
	 
	    public Brics updateBric(Brics bric) {
	        if (bricsMap.get(bric.getMobileNo()) != null) {
	        	bricsMap.get(bric.getMobileNo()).setCustName(bric.getCustName());
	        } else {
	        	bricsMap.put(bric.getMobileNo(), bric);
	        }
	        return bricsMap.get(bric.getMobileNo());
	    }
	 
	    public Brics deleteUser(String mobile) {
	    	Brics userResponse = bricsMap.remove(mobile);
	        return userResponse;
	    }
	 
	 
	}
 
