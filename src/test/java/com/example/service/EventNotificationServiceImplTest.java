package com.example.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Attendee;
import com.example.Event;
import com.example.EventType;

class EventNotificationServiceImplTest {
	
	EventNotificationService eventNotificationService = new EventNotificationServiceImpl();
	//Crear una evento
    Event myEvent = new Event(1L, "EventoTic", EventType.TECH, eventNotificationService);//Crea evento
	
    @BeforeEach
	void datosComunes() throws Exception {
		
        Attendee Asistente1 = new Attendee(1L, "Juan", "asistente1@gmail.com");
        Attendee Asistente2 = new Attendee(2L, "Carmen", "asistente2@gmail.com");
        myEvent.addAttendee(Asistente1);
        myEvent.addAttendee(Asistente2);
        
        assertEquals(2,myEvent.getAttendees().size());
        
        myEvent.notifyAssistants();
		
	}

	@Test
	void testAnnounce() {
		fail("Not yet implemented");
	}

	@Test
	void testConfirmAttendance() {
		fail("Not yet implemented");
	}

}
