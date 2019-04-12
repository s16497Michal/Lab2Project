package web;

import repository.ImplementedUserRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("afterLogin/setAccess")
public class UserAccess extends HttpServlet {
    private static long serialVersionUTD = 3L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = (HttpSession) req.getAttribute("premium");
        ImplementedUserRepo.setPremiumAccess(req.getParameter("username"));
        Boolean isAccomplishment = ImplementedUserRepo.checkPremiumAccess(req.getParameter("username"));

        if (isAccomplishment) {
            resp.getWriter().print("Nadales uzytkownikowi uprawnienia premium!");
        } else {
            resp.getWriter().print("Usunałes uzytkownikowi uprawnienia premium!");
        }
    }
}
