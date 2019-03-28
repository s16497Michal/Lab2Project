package web;

import repository.ImplementedUserRepo;
import repository.UsersRepository;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/newacct")
public class RegisterUser extends HttpServlet {
    private static final long serialVersionUTD = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        final User currentUser;
        if (SessionRegistry.sessionRegistry.containsKey(session.getId())) {
            currentUser = SessionRegistry.sessionRegistry.get(session.getId());
        }
        User user = registerMe(req);
        UsersRepository repository = new ImplementedUserRepo();
        user.setAdminAccess(true);
        repository.addUser(user);
        SessionRegistry.sessionRegistry.put(session.getId(), user);
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
