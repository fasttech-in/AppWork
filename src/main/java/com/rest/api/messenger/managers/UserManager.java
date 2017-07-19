package com.rest.api.messenger.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import app.constants.GenericConstants;
import app.models.Authenticate;
import app.models.User;

import com.rest.api.constants.UserMessagesConstants;
import com.rest.api.messenger.database.DatabaseFactory;

public class UserManager {

	static private Map<String, User> usersMap = DatabaseFactory.getUsers();

	public UserManager() {
		User superUser = new User("Super User","B.E",
				27,"Pune","Software Developer",GenericConstants.EXTERNAL_SUPER_USER,
				"abc@gmail.com","9503462575");
		usersMap.put(superUser.getREGISTRATION_ID(), superUser);
		
	}

	public List<User> getAllUsers() {
		return new ArrayList<User>(usersMap.values());
	}

	public String addNewUser(User user) {
		if (!usersMap.containsKey(user.getREGISTRATION_ID())){
			usersMap.put(user.getREGISTRATION_ID(), user);
			return user.getREGISTRATION_ID();
		}else{
			return UserMessagesConstants.USER_EXISTS_MSG;
		}
	}
	
	public User authenticateUser(Authenticate auth) {
		if (usersMap.containsKey(auth.getREG_ID())) {
			User user = usersMap.get(auth.getREG_ID());
			return authenticatePassword(user, auth) == true ? user : null;
		}
		for (Map.Entry<String, User> u : usersMap.entrySet()) {
			if (u.getValue().getEMAIL().equalsIgnoreCase(auth.getEMAIL())) {
				User user = usersMap.get(u.getValue().getREGISTRATION_ID());
				return authenticatePassword(user, auth) == true ? user : null;
			}
			if (u.getValue().getMOBILE().equalsIgnoreCase(auth.getMOBILE())) {
				User user = usersMap.get(u.getValue().getREGISTRATION_ID());
				return authenticatePassword(user, auth) == true ? user : null;
			}
		}
		return null;
	}

	private boolean authenticatePassword(User user, Authenticate auth) {
		return auth.getPWD().equals("password")? true:false;
	}

	public User getUser(String id) {
		if (usersMap.containsKey(id)) {
			User user = usersMap.get(id);
			return user;
		}
		return null;
	}
}
