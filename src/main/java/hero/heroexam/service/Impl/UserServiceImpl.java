package hero.heroexam.service.Impl;

import hero.heroexam.domain.entity.User;
import hero.heroexam.domain.service.UserServiceModel;
import hero.heroexam.repository.UserRepository;
import hero.heroexam.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {
        User user = this.modelMapper.map(userServiceModel, User.class);
        return this.modelMapper.map(this.userRepository.saveAndFlush(user), UserServiceModel.class);
    }

    @Override
    public UserServiceModel findByUsername(String username) {

        return this.userRepository.findByUsername(username).map(user -> this.modelMapper.map(user, UserServiceModel.class)).orElse(null);
    }
}
