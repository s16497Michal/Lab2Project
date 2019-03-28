package repository;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class ImplementedUserRepo implements UsersRepository {
    private static List<User> db = new ArrayList<User>();
    public User getUserByUsername(String username) {
        for (User user : db) {
            if (user.getEmail().equalsIgnoreCase(username))
                return user;
        }
        return null;
    }

    public void addUser(User user) {
        db.add(user);
    }

    public void setPremiumAccess(String username) {
        for (User user : db) {
            if (user.getUsername().equals(username)) {
                if (user.isPremium()) {
                    user.setPremium(false);
                } else
                    user.setPremium(true);
            }
        }
    }

    public boolean showUseres(String username, String pass) {
        boolean isLogin = false;
        for (User user : db) {
            if (user.getUsername().equals(username) && user.getPassword().equals(pass))
                isLogin = true;
            else
                isLogin = false;
        }
        return isLogin;
    }

    public Boolean checkPremiumAccess(String username) {
        boolean isPremeiumAccess = false;
        for (User user : db) {
            if (user.getUsername().equals(username)) {
                if (user.isPremium())
                    isPremeiumAccess = true;
                else
                    isPremeiumAccess = false;
            }
        }
        return isPremeiumAccess;
    }

    public List getUsers() {
        List<User> list = new ArrayList<User>();
        List<String> users = new ArrayList<String>();
        for (User user : db)
            list.add(user);
        for (int i=0; i<list.size(); i++){
            users.add(list.get(i).getUsername());
            users.add(list.get(i).getPassword());
            users.add(list.get(i).getEmail());
            users.add(String.valueOf(list.get(i).isPremium()));
        }
        return users;
    }

    public String getUser(String username) {
        for (User user : db) {
            if (user.getUsername().equals(username))
                return user.getUsername();
        }
        return null;
    }

    public void checkAdminAccess(String username) {
        for (User user : db) {
            if (user.getUsername().equals("admin"))
                user.setAdminAccess(true);
            else
                user.setAdminAccess(false);
        }
    }
}
