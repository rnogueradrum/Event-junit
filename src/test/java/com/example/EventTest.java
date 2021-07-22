package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.example.service.EventNotificationService;
import com.example.service.EventNotificationServiceImpl;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EventTest {
	
	EventNotificationService eventNotificationService = new EventNotificationServiceImpl();
	
	
    Event myEvent = new Event(1L, "EventoTic", EventType.TECH, eventNotificationService);//Crea evento
    
    Attendee asistente1 = new Attendee(1L, "Juan", "asistente1@gmail.com");
    Attendee asistente2 = new Attendee(2L, "Carmen", "asistente2@gmail.com");
    
  
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Order(2)
    @Test
    @DisplayName("If Attendee null addAttendee Test")
	void addAttendeeNullAttendeetest() throws NullPointerException {
		
		asistente1 = null;
		assertNull(asistente1);
		
		myEvent.addAttendee(asistente1);
		assertEquals(0,myEvent.getAttendees().size());
		
	}
	
	@Order(4)
    @Test
    @DisplayName("If Attendees null addAttendee Test")
	void addAttendeesNullAttendeetest() {
		
		myEvent.setAttendees(null);
		assertNull(myEvent.getAttendees());
		
		myEvent.addAttendee(asistente1);
		assertEquals(1,myEvent.getAttendees().size());
		assertNotNull(myEvent.getAttendees());
		
	}

}
