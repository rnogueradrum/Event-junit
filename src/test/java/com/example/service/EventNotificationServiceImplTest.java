package com.example.service;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.example.Attendee;
import com.example.Event;
import com.example.EventType;
import com.example.Notification;



@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EventNotificationServiceImplTest {
	
	EventNotificationService eventNotificationService = new EventNotificationServiceImpl();
	
	
    Event myEvent = new Event(1L, "EventoTic", EventType.TECH, eventNotificationService);//Crea evento
    
    Attendee asistente1 = new Attendee(1L, "Juan", "asistente1@gmail.com");
    Attendee asistente2 = new Attendee(2L, "Carmen", "asistente2@gmail.com");
    
  
    @Order(2)
    @Test
    @DisplayName("If Event null announce Test")
    void announceIfEventNullTest() throws NullPointerException {
    	
    	
    	myEvent = null;
        assertNull(myEvent);
       
    	eventNotificationService.announce(myEvent);
    	assertNull(myEvent);
        }
    
    @Order(4)
    @Test
    @DisplayName("If Attendees Null Test")
    void announceIfAttendeesNullTest() {
    	
    	myEvent.setAttendees(null);
    	assertNull(myEvent.getAttendees());
    	
    	myEvent.notifyAssistants();
        assertNull(myEvent.getAttendees());
        
        }
    
    @Order(6)
    @Test
    @DisplayName("If Attendees isEmpty Test")
    void announceIfAttendeesIsEmptyTest() {
    	
    	assertTrue(myEvent.getAttendees().isEmpty());
        
    	myEvent.notifyAssistants();
        assertTrue(myEvent.getAttendees().isEmpty());
        
        }
    
    
    @Order(8)
    @Test
    @DisplayName("Attendees announce Test")
    void announceAttendeesTest() {
    	myEvent.addAttendee(asistente1);
        myEvent.addAttendee(asistente2);
        
        assertEquals(2,myEvent.getAttendees().size());
        
    	assertNotNull(myEvent);
        assertNotNull(myEvent.getAttendees());
        assertFalse(myEvent.getAttendees().isEmpty());
        
        myEvent.notifyAssistants();
        
        for (Attendee attendee : myEvent.getAttendees()) { 
            assertNotNull(attendee.getNotifications());
            //System.out.println(attendee.getNotifications().get(0).getMessage());
        	
        }
    }
    
    
    @Order(10)
    @DisplayName("If Event null ConfirmAttendance Test")
	@Test
	void confirmAttendanceIfEventNullTest() {
    	myEvent = null;
        assertNull(myEvent);
        
        assertNotNull(asistente1);
    	
    	eventNotificationService.confirmAttendance(myEvent, asistente1);
    	assertNull(myEvent);
		
	}
    
    @Order(12)
    @DisplayName("If Attendee null ConfirmAttendance Test")
	@Test
	void confirmAttendanceIfAttendeeNullTest() {
    	
    	assertNotNull(myEvent);
    	
    	asistente1 = null;
        assertNull(asistente1);
    	
    	eventNotificationService.confirmAttendance(myEvent, asistente1);
    	assertNull(asistente1);
		
	}
    
    @Order(14)
    @DisplayName("If valid Event and Attendee ConfirmAttendance Test")
	@Test
	void confirmAttendanceValidTest() {
    	
    	assertNotNull(myEvent);
  
        assertNotNull(asistente1);
    	
    	eventNotificationService.confirmAttendance(myEvent, asistente1);
    	assertNotNull(asistente1.getNotifications().get(0).getMessage());
		System.out.println(asistente1.getNotifications().get(0).getMessage());
	}

}
