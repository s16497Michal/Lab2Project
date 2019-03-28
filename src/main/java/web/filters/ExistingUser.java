package web.filters;

import repository.ImplementedUserRepo;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/", servletNames = "RegisterUser")
public class ExistingUser implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (new ImplementedUserRepo().getUser(servletRequest.getParameter("username")) != null) {
            servletResponse.getWriter().println("Taki uzytkownik juz istnieje!");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
