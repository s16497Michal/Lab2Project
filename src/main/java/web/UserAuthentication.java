package web;

import repository.ImplementedUserRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*; //padl mi telefon wait
import java.io.IOException;

@WebServlet("/afterLogin/goInside")
public class UserAuthentication extends HttpServlet {
    private static final long serialVersionUTD = 2L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isPremium = ImplementedUserRepo.checkPremiumAccess(req.getParameter("username"));
        String authenticatedUsername = req.getParameter("username");
        String authenticatedPass = req.getParameter("pass");
        boolean canLogin = ImplementedUserRepo.showUseres(authenticatedUsername, authenticatedPass);
        if (ImplementedUserRepo.showUseres(authenticatedUsername, authenticatedPass)) {
            HttpSession session = req.getSession();
            session.setAttribute("user", authenticatedUsername);
            session.setAttribute("premium", ImplementedUserRepo.checkPremiumAccess(authenticatedUsername));
            if (ImplementedUserRepo.checkPremiumAccess(authenticatedUsername))
                resp.sendRedirect("afterLogin/welcome_new_premium.jsp");
            else
                req.getRequestDispatcher("/afterLogin/welcome_new.jsp").forward(req, resp);
        } else
            resp.sendRedirect("");

    }
}
