package com.rest.api.messenger.database;

import java.util.HashMap;
import java.util.Map;

import app.models.Event;
import app.models.User;
import app.models.UserProfile;

public class DatabaseFactory {

	private static Map<Long, Event> eventsCache = new HashMap<>();
	private static Map<String, User> usersCache = new HashMap<>();
	private static Map<String, UserProfile> profileCache = new HashMap<>();
	private static Map<String, UserProfile> subscriptionCache = new HashMap<>();
	
	public DatabaseFactory() {
	 
	}
	
	public static Map<Long, Event> getEvents() {
		return eventsCache;
	}

	public static Map<String, User> getUsers() {
		return usersCache;
	}

	public static Map<String, UserProfile> getUserProfiles() {
		return profileCache;
	}
	
	
}
