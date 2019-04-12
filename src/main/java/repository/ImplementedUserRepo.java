package repository;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class ImplementedUserRepo {
    private static List<User> db = new ArrayList<User>();
    public static User getUserByUsername(String username) {
        for (User user : db) {
            if (user.getEmail().equalsIgnoreCase(username))
                return user;
        }
        return null;
    }

    public static void addUser(User user) {
        db.add(user);
    }

    public static void setPremiumAccess(String username) {
        for (User user : db) {
            if (user.getUsername().equals(username)) {
                if (user.isPremium()) {
                    user.setPremium(Boolean.FALSE);
                } else
                    user.setPremium(Boolean.TRUE);
            }
        }
    }

    public static boolean showUseres(String username, String pass) {
        boolean isLogin = false;
        for (User user : db) {
            isLogin = user.getUsername().equals(username) && user.getPassword().equals(pass);
        }
        return isLogin;
    }

    public static Boolean checkPremiumAccess(String username) {
        Boolean isPremeiumAccess = Boolean.FALSE;
        for (User user : db) {
            if (user.getUsername().equals(username)) {
                if (user.isPremium())
                    isPremeiumAccess = Boolean.TRUE;
                else
                    isPremeiumAccess = Boolean.FALSE;
            }
        }
        return isPremeiumAccess;
    }

    public static List getUsers() {
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

    public static String getUser(String username) {
        for (User user : db) {
            if (user.getUsername().equals(username))
                return user.getUsername();
        }
        return null;
    }

    public static void checkAdminAccess(String username) {
        for (User user : db) {
            if (user.getUsername().equals("admin"))
                user.setAdminAccess(true);
            else
                user.setAdminAccess(false);
        }
    }
}
