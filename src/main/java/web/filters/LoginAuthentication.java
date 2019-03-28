package web.filters;

import model.User;
import repository.ImplementedUserRepo;
import repository.UsersRepository;
import web.SessionRegistry;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Null;
import java.io.IOException;

@WebFilter(urlPatterns = "/", servletNames = "LoginUser")
public class LoginAuthentication implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        HttpSession session = httpServletRequest.getSession(false);
        final String authenticatedUsername = servletRequest.getParameter("username");
        String authenticatedPass = servletRequest.getParameter("pass");

        System.out.println(authenticatedUsername+ " " + authenticatedPass);

        if (!new ImplementedUserRepo().showUseres(authenticatedUsername, servletRequest.getParameter("pass"))) {
            servletResponse.getWriter().print("Haslo lub login sa nieprawidlowe.");
            return;
        }
        final User currentUser = new User();
        currentUser.setUsername(authenticatedUsername);
        SessionRegistry.sessionRegistry.put(session.getId(), currentUser);

        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
