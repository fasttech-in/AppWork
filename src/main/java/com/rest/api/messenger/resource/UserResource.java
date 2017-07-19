package com.rest.api.messenger.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import app.models.Authenticate;
import app.models.Event;
import app.models.User;

import com.rest.api.messenger.managers.UserManager;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource extends BaseResource {

	static UserManager userManager = new UserManager();
	
	@GET
	public List<User> getUsers() {
		return userManager.getAllUsers();
	}
	
	@GET
	@Path("/{registrationId}")
	public User getUser(@PathParam("registrationId") String id) {
		return userManager.getUser(id);
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String addNewUser(User user) {
		return userManager.addNewUser(user);
	}
	
	@POST
	@Path("/authenticate")
	public User authenticateUser(Authenticate auth) {
		return userManager.authenticateUser(auth);
	}
}
