package com.rest.api.messenger.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.api.messenger.managers.EventManager;
import com.rest.api.messenger.models.Event;

@Path("/events")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EventResource extends BaseResource{

	static EventManager eventManager = new EventManager();
	
	@GET
	public List<Event> getEvents() {
		return eventManager.getEvents();
	}
	
	@GET
	@Path("/{eventid}")
	public Event getEvent(@PathParam("eventid") long id) {
		return eventManager.getEvent(id);
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String addNewEvent(Event event) {
		return eventManager.addNewEvent(event);
	}
	
	@PUT
	@Path("/{eventid}")
	@Produces(MediaType.TEXT_PLAIN)
	public String updateEvent(@PathParam("eventid") long id ,Event event) {
		event.setId(id);
		return eventManager.updateEvent(event);
	}

	@DELETE
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String removeEvent(@PathParam("id") long id) {
		return eventManager.removeEvent(id);
	}
	
	@GET
	@Path("/hitcounter")
	@Produces(MediaType.TEXT_PLAIN)
	public String getHitCounts() {
		return String.valueOf(getHitCounter());
	}
}
