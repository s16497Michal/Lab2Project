package web;

import repository.ImplementedUserRepo;
import repository.UsersRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/showuseres")
public class ShowUsers extends HttpServlet {
    private static long serialVersionUTD = 4L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UsersRepository repository = new ImplementedUserRepo();
        resp.getWriter().println(repository.getUsers());

        session.setAttribute("sess", repository.getUsers());
    }
}
