package web;

import repository.ImplementedUserRepo;
import repository.UsersRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("afterLogin/setAccess")
public class UserAccess extends HttpServlet {
    private static long serialVersionUTD = 3L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsersRepository repository = new ImplementedUserRepo();
        repository.setPremiumAccess(req.getParameter("username"));
        boolean isAccomplishment = repository.checkPremiumAccess(req.getParameter("username"));

        if (isAccomplishment)
            resp.getWriter().print("Nadales uzytkownikowi uprawnienia premium!");
        else
            resp.getWriter().print("Usunałes uzytkownikowi uprawnienia premium!");
    }
}
