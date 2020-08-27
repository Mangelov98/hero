package hero.heroexam.service;

import hero.heroexam.domain.service.UserServiceModel;

public interface UserService {
    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsername(String username);
}
