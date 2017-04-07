package repostories;

import java.util.ArrayList;
import java.util.List;

import domain.Privilege;
import domain.User;

public class UserRepository implements IUserRepository {
	////////////////////////////////////
	/// REFAKTOR !!!!! ////////////////
	////////////////////////////////////
	private static List<User> db = new ArrayList<User>();
	
	public UserRepository() {
		if (db.isEmpty()) {
			User user1 = new User();
			user1.setUsername("Mikolaj");
			user1.setPassword("1234");
			user1.setEmail("mikolaj.chodkowski@mikolaj.com");
			user1.setPrivilege(Privilege.ADMIN);
			
			User user2 = new User();
			user2.setUsername("Piotr");
			user2.setPassword("1234");
			user2.setEmail("piotr.kunowski@piotr.com");
			user2.setPrivilege(Privilege.NORMAL);
			
			User user3 = new User();
			user3.setUsername("Grzegorz");
			user3.setPassword("1234");
			user3.setEmail("grzegorz.kochanski@grzegorz.com");
			user3.setPrivilege(Privilege.PREMIUM);
			
			db.add(user1);
			db.add(user2);
			db.add(user3);
		}
	}

	public void add (User user) {
		db.add(user);
	}
	
	public boolean logIn (User user) {
		for (User userDb : db) {
			if (userDb.getUsername().
					equals(user.getUsername()) && userDb.getPassword().equals(user.getPassword())) {
				return true;
			}
		}
		return false;
	}
	
	public List<User> getAllUsers() {
		return db;
	}
	
	public String getEmailOfUser(User user) {
		for (User userDb : db) {
			if (userDb.getUsername().equals(user.getUsername())) {
				return userDb.getEmail();
			}
		}
		return "There is no such user in database";
	}
	
	public String getPrivilegeOfUser(User user) {
		for (User userDb : db) {
			if (userDb.getUsername().equals(user.getUsername())) {
				return userDb.getPrivilege().toString();
			}
		}
		return "There is no such user in database";
	}
	
	public void setPremium(User user) {
		for (User userDb : db) {
			if (userDb.getUsername().equals(user.getUsername())) {
				userDb.setPrivilege(Privilege.PREMIUM);
			}
		}
	}
	
	public void removePremium(User user) {
		for (User userDb : db) {
			if (userDb.getUsername().equals(user.getUsername())) {
				userDb.setPrivilege(Privilege.NORMAL);
			}
		}
	}
}
