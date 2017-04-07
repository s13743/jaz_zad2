package web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repostories.UserRepository;
import domain.User;

@WebFilter({"log.jsp", "registration.jsp"})
public class logInSignUpFilter implements Filter {
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			HttpSession session = httpRequest.getSession();
			
			if (session.getAttribute("username")!= null) {
				User user = (User) session.getAttribute("username");
				UserRepository repository = new UserRepository();
				String privilege = repository.getPrivilegeOfUser(user);
		
				if ( privilege.equals("NORMAL") || privilege.equals("PREMIUM") || privilege.equals("ADMIN") ) {
					response.getWriter().print("You have logged in already");
					HttpServletResponse httpResponse = (HttpServletResponse) response;
					httpResponse.sendRedirect("/profileServlet");
				}
			}
			
			chain.doFilter(request, response);
		}
		
		@Override
		public void destroy() {
		}
		
		@Override
		public void init(FilterConfig arg0) throws ServletException {
		}
}
