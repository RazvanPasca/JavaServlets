package service;

public class AdminService {
    public boolean isAdminValid(String username, String password) {
        return username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin");
    }
}
