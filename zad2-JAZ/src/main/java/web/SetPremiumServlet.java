package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repostories.IUserRepository;
import repostories.UserRepository;
import domain.User;

@WebServlet("/premium")
public class SetPremiumServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User user = retrieveUserFromRequest(request, response);
		IUserRepository repository = new UserRepository();
		
		if(request.getParameter("premium").equals("set")) {
			repository.setPremium(user);
		} else {
			repository.removePremium(user);
		}
		
		response.sendRedirect("/allUsersServlet");
	}
	
	//if nie ma takiego u¿ytkownika przekieruj na error i filtr, ¿eby tylko admin tutaj móg³ wejœæ
	
	private User retrieveUserFromRequest (HttpServletRequest request, HttpServletResponse response) throws IOException {
		User result = new User();
		result.setUsername(request.getParameter("username"));
		return result;
	}

}
