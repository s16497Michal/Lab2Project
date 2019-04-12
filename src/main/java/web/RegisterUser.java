package web;

import repository.ImplementedUserRepo;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/newacct")
public class RegisterUser extends HttpServlet {
    private static final long serialVersionUTD = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = registerMe(req);
        ImplementedUserRepo.addUser(user);
        ImplementedUserRepo.checkAdminAccess(user.getUsername());
        if (user.isAdminAccess())
            resp.sendRedirect("afterLogin/welcome_new_adm.jsp");
        else
            resp.sendRedirect("login.jsp");
    }

    private User registerMe (HttpServletRequest request) {
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("pass"));
        user.setEmail(request.getParameter("email"));
        if (request.getParameter("username").equals("admin"))
            user.setAdminAccess(true);
        else
            user.setAdminAccess(false);
        return user;
    }
}
