package repostories;

import java.util.List;

import domain.User;

public interface IUserRepository {
	
	void add (User user);
	boolean logIn(User uer);
	List<User> getAllUsers();
	String getEmailOfUser(User user);
	String getPrivilegeOfUser(User user);
	void setPremium (User user);
	void removePremium (User user);
}
