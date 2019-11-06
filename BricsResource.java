package cgg.gov.in.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;


public class BricsResource {
	
	@Path("BricksOrder")
	@POST
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public JSONObject insertOrders(@PathParam("name") String customerName,@PathParam("count") int BrickCount)throws SQLException{
	               String orderId=null;
	 JSONObject res=new JSONObject();
	PreparedStatement ps=null;
	String sql=null;
	ResultSet rs=null;
	int max=0;
	String customerUniqId=null;
	Connection con=null;
	try {
	Class.forName("org.postgresql.Driver");
	 con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/databasename","username","password");
	  
	sql="select nextval(brikorders) ";  
	ps=con.prepareStatement(sql);
	rs=ps.executeQuery();
	if(rs !=null && rs.next()){
		max=rs.getInt(1);
	}
	
	customerUniqId="BRICK"+String.valueOf((max));
	sql="insert into bricks(customer_id,mobile,customername,no_of_bricks,order_date) values (?,?,?,?,now())";
	ps=con.prepareStatement(sql);
	ps.setInt(1,max);
	ps.setString(2,customerName);
	ps.setString(3,customerUniqId);
	ps.setInt(4,BrickCount);
	ps.executeUpdate();

	res.put("msg","Your Order Has been Booked and your order id is "+customerUniqId);
	}catch(Exception ex){
	ex.printStackTrace();
	}
finally{
		
		con.close();
	}
	return res;
	}


	

	@Path ("GetData")
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public JSONObject getOrderData(@PathParam("customerId") String customerId) throws SQLException{
	             JSONObject res=new JSONObject();
	PreparedStatement ps=null;
	String sql=null;
	ResultSet rs=null;
	Connection con=null;
	try{
	Class.forName("org.postgresql.Driver");
	  con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/databasename","username","password");
	 
	sql="select customer_id,mobile,customername,no_of_bricks,order_date,coalesce(status,0) as  status from  bricks where  customer_id='"+customerId+"' ";
	ps=con.prepareStatement(sql);
	rs=ps.executeQuery();
	if(rs!= null && rs.next()){
	res.put("msg", "Your Order is for "+rs.getInt("no_bricks")+" Bricks is recieved.");
	}else{
	res.put("msg","Invalid Order Id,Please Enter Correct Order id ");
	}

	}catch(Exception e){
	e.printStackTrace();
	}
finally{
		
		con.close();
	}
	return res;
	}

	// updating order 
	@Path("updateOrder")
	@PUT
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public JSONObject updateOrders(@PathParam("customerId") String customerId,@QueryParam("count") int BrickCount) throws SQLException{
	               String orderId=null;
	JSONObject res=new JSONObject();
	PreparedStatement ps=null;
	String sql=null;
	ResultSet rs=null;
	int dispatchStatus=0;
	Connection con=null;
	try {
	Class.forName("org.postgresql.Driver");
	 con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/databasename","username","password");
	 

	sql="select case when coalesce(status,0)=1 then 1 else 0  end   as status from  bricks where  customer_id='"+customerId+"' ";
	ps=con.prepareStatement(sql);
	rs=ps.executeQuery();
			
			if(rs!= null && rs.next()){
	 dispatchStatus=rs.getInt(1);
	}else{
	res.put("msg","Invalid Order Id,Please Enter Correct Order id");
	}
	if(dispatchStatus==1){
	res.put("msg","Your Order has been dispatched.You cannot update it ");
	}else{
	sql="update  bricks_orders set no_of_bricks=? where customer_id=? ";
	ps=con.prepareStatement(sql);
	ps.setInt(1,BrickCount);
	ps.setString(2,customerId);
	int sqlRes =ps.executeUpdate();
	if(sqlRes > 0) {
	res.put("msg","Your Order Has been updated for "+BrickCount+" bricks and your order ref id is "+customerId+"");
	}
	}
}catch(Exception ex){
	ex.printStackTrace();
	}
	finally{
		
		con.close();
	}

	return res;
	}
}

	 
	


 
