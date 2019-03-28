package repository;

import model.User;

import java.util.List;

public interface UsersRepository {
    User getUserByUsername (String username);
    void addUser (User user);
    void setPremiumAccess(String email);
    Boolean checkPremiumAccess(String username);
    boolean showUseres(String username, String pass);
    List getUsers();
    String getUser(String username);
    void checkAdminAccess(String username);
}
