package service;

public class UserService {

    public boolean isUserValid(String username, String password) {
        return username.equalsIgnoreCase("pasca") && password.equalsIgnoreCase("pasca");
    }
}
