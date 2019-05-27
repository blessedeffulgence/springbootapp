package application.services;

import application.model.User;

public interface UserService {
    User findUserByEmail(String email);

    void saveUser(User user);
}
