package TicketReserve;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class TicketCRUD {

	// ______________________add___________________________
	public void addTicket(Ticket ticket) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		addTicket(session, ticket);
		tx.commit();
		session.close();

	}

	private void addTicket(Session session, Ticket t) {
		Ticket ticket = new Ticket();
		ticket.setDate(t.getDate());
		ticket.setDeparturGate(t.getDeparturGate());
		ticket.setDeparturTime(t.getDeparturTime());
		ticket.setFlightNumber(t.getFlightNumber());
		ticket.setFrom(t.getFrom());
		ticket.setId(t.getId());
		ticket.setPassengerName(t.getPassengerName());
		ticket.setSeat(t.getSeat());
		ticket.setTo(t.getTo());
		session.save(ticket);
		System.out.println("add1");
	}

	// _______________________read_______________________
	public List<Ticket> getTicket(Session session) {
		
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Ticket");
		List<Ticket> tickets = query.list();
		System.out.println(tickets.get(0).getTo());
		System.out.println(tickets.get(0).getDate());
		tx.commit();
		
		return tickets;
	}
	
//______________________________readOne__________________________
	public Ticket getOneticket(int id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		String state = "select from Ticket where id = :id";
		Query query = session.createQuery(state);
		query.setInteger("id", id);
		Ticket t = new Ticket();
		List<Ticket> ticket = query.list();
		t.setDate(ticket.get(0).getDate());
		t.setDeparturGate(ticket.get(0).getDeparturGate());
		t.setDeparturTime(ticket.get(0).getDeparturTime());
		t.setFlightNumber(ticket.get(0).getFlightNumber());
		t.setFrom(ticket.get(0).getFrom());
		t.setTo(ticket.get(0).getTo());
		t.setPassengerName(ticket.get(0).getPassengerName());
		t.setSeat(ticket.get(0).getSeat());
		t.setId(id);
		tx.commit();
		session.close();
		return t;
	}
	
	
	
	
	
	// _________________________delete____________________

	public int deleteTicket(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		String state = "delete from Ticket where id = :id";
		Query query = session.createQuery(state);
		query.setInteger("id", id);
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
	// ______________________update___________________________

	public int updateTicket(int id, Ticket t) {
		if (id <= 0)
			return 0;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		String hql = "update Ticket set  passengerName =:passengerName , To = : To,From =:From, date = :date,"
				+ " departureTime =: departureTime, departureGate  = :departureGate ,flightNumber =:flightNumber,"
				+ " seat=:seat where id = :id";

		Query query = session.createQuery(hql);
		query.setInteger("id", t.getId());
		query.setString(" passengerName", t.getPassengerName());
		query.setInteger("seat", t.getSeat());
		query.setString("To", t.getTo());
		query.setString("From", t.getFrom());
		query.setString("departureGate", t.getDeparturGate());
		query.setInteger("flightNumber", t.getFlightNumber());
		query.setInteger("departureTime", t.getDeparturTime());
		query.setString("date", t.getDate());
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}

}
