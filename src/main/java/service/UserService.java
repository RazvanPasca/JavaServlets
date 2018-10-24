package service;

import entities.UserEntity;
import lombok.AllArgsConstructor;
import repository.UserRepo;

import java.util.List;

@AllArgsConstructor
public class UserService {

    UserRepo userRepo;

    public boolean isUserValid(String username, String password) {
        List<UserEntity> users = userRepo.findUsersByUsername("pasca");
        System.out.println(users);

        return username.equalsIgnoreCase("pasca") && password.equalsIgnoreCase("pasca");
    }
}
