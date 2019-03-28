package web;

import model.User;

import java.util.HashMap;
import java.util.Map;

public class SessionRegistry {
    public static Map<String, User> sessionRegistry = new HashMap<String, User>();
}
