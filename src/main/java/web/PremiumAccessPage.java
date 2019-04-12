package web;

import repository.ImplementedUserRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/go-to-premium")
public class PremiumAccessPage extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String currentUser = (String) session.getAttribute("user");
        if (ImplementedUserRepo.checkPremiumAccess(currentUser))
            resp.sendRedirect("afterLogin/welcome_new_premium.jsp");
        else
            resp.sendRedirect("afterLogin/welcome_new.jsp");
    }
}
