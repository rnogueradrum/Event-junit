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
    
    
    
}
