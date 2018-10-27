package service;

import entities.UserEntity;
import lombok.AllArgsConstructor;
import repository.UserRepo;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class UserService {

    UserRepo userRepo;


    public Optional<UserEntity> areCredentialsValid(String username, String pass) {
        List<UserEntity> users = userRepo.findUsersByUsername(username);

        Optional<UserEntity> user = users.stream().filter(e -> e.getPassword().equalsIgnoreCase(pass)).findFirst();

        return user;
    }

    public List<UserEntity> findAllUsers() {
        List<UserEntity> users = userRepo.findAllUsers();
        return users;
    }
}
