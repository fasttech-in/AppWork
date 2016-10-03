package com.rest.api.messenger.managers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import app.models.Event;

import com.rest.api.constants.UserMesseagesConstants;
import com.rest.api.messenger.database.DatabaseFactory;

public class EventManager {
	
	static private Map<Long, Event> eventsMap = DatabaseFactory.getEvents();

	public EventManager() {
		eventsMap.put(1L, new Event(1, "Weekly Meeting", "Meeting", "Meeting Description", 
				"Pune", "Sanjeet", "9503462575",
				"2016-10-01T18:30:00.000Z",
						"2016-10-01T18:30:00.000Z"));
		eventsMap.put(2L, new Event(2, "Weekly Meeting", "Meeting", "Meeting Description", 
				"Mumbai", "Pravin", "9503462575",
				"2016-10-01T18:30:00.000Z",
				"2016-10-01T18:30:00.000Z"));
	}

	public List<Event> getEvents(){
		return new ArrayList<Event>(eventsMap.values());
	}
	
	public String addNewEvent(Event event) {
		event.setId(eventsMap.size()+1);
		eventsMap.put(event.getId(), event);
		return UserMesseagesConstants.EVENT_ADD_SUCCESS_MSG;
	}
	
	public String updateEvent(Event event) {
		if(event.getId() == 0){
			return null;
		}
		if(eventsMap.containsKey(event.getId())){
			eventsMap.remove(event.getId());
		}
		eventsMap.put(event.getId(), event);
		return UserMesseagesConstants.EVENT_UPDATE_SUCCESS_MSG;
	}
	
	public String removeEvent(long id) {
		Event event = null;
		if(eventsMap.containsKey(id)){
			event = eventsMap.get(id);
			eventsMap.remove(id);
		}
		return UserMesseagesConstants.EVENT_REMOVE_SUCCESS_MSG;
	}
	
	public Event getEvent(long id) {
		return eventsMap.get(id);
	}
}
