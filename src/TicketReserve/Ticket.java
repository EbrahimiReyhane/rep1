package TicketReserve;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name= "Ticket") 
public class Ticket {
@Id @GeneratedValue
@Column(name = "medicine_id", unique = true, nullable = false)
	private int id;
@Column
	private String passengerName;
@Column
	private String To;
@Column
	private String From;
@Column
	private String date;
@Column
	private int departureTime;
@Column
	private String departureGate;
@Column
	private int flightNumber;
@Column
	private int seat;

	Ticket(){
		
	}
	
	public Ticket(int id, String passengerName) {
		super();
		this.id = id;
		this.passengerName = passengerName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getTo() {
		return To;
	}

	public void setTo(String to) {
		To = to;
	}

	public String getFrom() {
		return From;
	}

	public void setFrom(String from) {
		From = from;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getDeparturTime() {
		return departureTime;
	}

	public void setDeparturTime(int departurTime) {
		this.departureTime = departurTime;
	}

	public String getDeparturGate() {
		return departureGate;
	}

	public void setDeparturGate(String departurGate) {
		this.departureGate = departurGate;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}
	
	
	
	

}
