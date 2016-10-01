package com.rest.api.messenger.database;

import java.util.HashMap;
import java.util.Map;

import com.rest.api.messenger.models.Event;

public class DatabaseFactory {

	private static Map<Long, Event> eventsMap = new HashMap<>();
	
	public DatabaseFactory() {
	 
	}
	
	public static Map<Long, Event> getEvents() {
		return eventsMap;
	}
}
