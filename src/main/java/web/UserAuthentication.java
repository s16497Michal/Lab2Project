package web;

import model.User;
import repository.ImplementedUserRepo;
import repository.UsersRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*; //padl mi telefon wait
import java.io.IOException;

@WebServlet("/afterLogin/goInside")
public class UserAuthentication extends HttpServlet {
    private static final long serialVersionUTD = 2L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UsersRepository repository = new ImplementedUserRepo();
        boolean isPremium = repository.checkPremiumAccess(req.getParameter("username"));
        final String authenticatedUsername = req.getParameter("username");
        String authenticatedPass = req.getParameter("pass");
        System.out.println(authenticatedUsername+ " " + authenticatedPass);
        resp.addCookie(new Cookie("SESSION", session.getId()));
        final User currentUser = new User();
        currentUser.setUsername(authenticatedUsername);
        SessionRegistry.sessionRegistry.put(session.getId(), currentUser);
        req.getRequestDispatcher("/afterLogin/welcome_new.jsp").forward(req, resp);
    }
}
