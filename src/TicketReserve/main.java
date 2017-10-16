package TicketReserve;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicketCRUD tc = new TicketCRUD();
		try {
			
			    Session session=HibernateUtil.getSessionFactory().openSession();
			      
			    //creating transaction object  
			    Transaction tx =session.beginTransaction();  
			     Ticket t = new Ticket(); 
			     t.setFrom("rtyhju");
			     t.setId(1);
			     t.setDate("dfgh");
			     t.setDeparturGate("g3");
			     t.setDeparturTime(23);
			     t.setFlightNumber(12);
			     t.setPassengerName("gh");
			     t.setSeat(34);
			     t.setTo("min");
			     
			     
			    Ticket s =  (Ticket) session.get(Ticket.class, 1);
		        System.out.println(s.getDate());
			      
			     tc.updateTicket(1, t);
			    tx.commit();//transaction is commited  
			    session.close();
			    
        } catch(HibernateException e) {
            e.printStackTrace();
        }
		

	}

}
