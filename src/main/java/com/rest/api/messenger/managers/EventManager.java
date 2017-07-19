package com.rest.api.messenger.managers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import app.models.Event;

import com.rest.api.constants.UserMessagesConstants;
import com.rest.api.messenger.database.DatabaseFactory;
import com.rest.api.messenger.exception.DataNotFoundException;

public class EventManager {
	
	static private Map<Long, Event> eventsMap = DatabaseFactory.getEvents();

	public EventManager() {
		eventsMap.put(1L, new Event(1, "Weekly Meeting", "Meeting", "Meeting Description", 
				"Pune", "Sanjeet", "9503462575",
				new Date(),
			    new Date()));
		eventsMap.put(2L, new Event(2, "Weekly Meeting", "Meeting", "Meeting Description", 
				"Mumbai", "Pravin", "9503462575",
				new Date(),
				new Date()));
	}

	public List<Event> getEvents(){
		return new ArrayList<Event>(eventsMap.values());
	}
	
	public String addNewEvent(Event event) {
		event.setId(eventsMap.size()+1);
		eventsMap.put(event.getId(), event);
		return UserMessagesConstants.EVENT_ADD_SUCCESS_MSG;
	}
	
	public String updateEvent(Event event) {
		if(event.getId() == 0){
			return null;
		}
		if(eventsMap.containsKey(event.getId())){
			eventsMap.remove(event.getId());
		}
		eventsMap.put(event.getId(), event);
		return UserMessagesConstants.EVENT_UPDATE_SUCCESS_MSG;
	}
	
	public String removeEvent(long id) {
		Event event = null;
		if(eventsMap.containsKey(id)){
			event = eventsMap.get(id);
			eventsMap.remove(id);
		}
		return UserMessagesConstants.EVENT_REMOVE_SUCCESS_MSG;
	}
	
	public Event getEvent(long id) {
		Event event = eventsMap.get(id);
		if(event == null){
			throw new DataNotFoundException("Event not found with event id "+id);
		}
		return event;
	}
}
