package TicketReserve;

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
import javax.ws.rs.core.Response;

import org.hibernate.Session;

@Path("/system")
public class TicketEntryManager {
//____________________CRUD__________________________//
@GET
@Path("/read")
@Produces(MediaType.APPLICATION_JSON)
public List< Ticket> getTicke() {
	System.out.println("connection");
	Session session = HibernateUtil.getSessionFactory().openSession();
	TicketCRUD crud = new TicketCRUD();
        List tickets = crud.getTicket(session);
        session.close();
        return tickets;
    }
@GET
@Path("/read/{id}")
@Produces(MediaType.APPLICATION_JSON)
public Ticket getonrTicket(@PathParam("id") int id){
	 TicketCRUD crud = new TicketCRUD();
	 Ticket t = crud.getOneticket(id);
	 return t;
}
 
@POST
@Path("/create")
@Consumes(MediaType.APPLICATION_JSON)
 public Response addTicket(Ticket ticket  ){
	         
	       TicketCRUD crud = new TicketCRUD();
	       crud.addTicket(ticket);
	        
	       return Response.ok().build();
	      
	    }
@PUT
@Path("/update/{id}")
@Consumes(MediaType.APPLICATION_JSON)
public Response updateTicket(@PathParam("id") int id, Ticket t){
    TicketCRUD crud = new TicketCRUD();
    int count = crud.updateTicket(id, t);
    if(count==0){
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    return Response.ok().build();
}
@DELETE
@Path("/delete/{id}")
@Consumes(MediaType.APPLICATION_JSON)
public Response deleteTicket(@PathParam("id") int id){
	TicketCRUD crud = new TicketCRUD();
    int count = crud.deleteTicket(id);
    if(count==0){
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    return Response.ok().build();
}


}
