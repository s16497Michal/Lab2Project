package web;

import repository.ImplementedUserRepo;
import repository.UsersRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/afterLogin/goInside")
public class LoginUser extends HttpServlet {
    private static final long serialVersionUTD = 2L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UsersRepository repository = new ImplementedUserRepo();
        boolean isPremium = repository.checkPremiumAccess(req.getParameter("username"));
        final String authenticatedUsername = req.getParameter("username");
        String authenticatedPass = req.getParameter("pass");
        System.out.println(authenticatedUsername+ " " + authenticatedPass);

        req.getRequestDispatcher("/afterLogin/welcome_new.jsp").forward(req, resp);
    }
}
