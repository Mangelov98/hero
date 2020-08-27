package hero.heroexam.repository;

import hero.heroexam.domain.entity.User;
import hero.heroexam.domain.service.UserServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByUsername(String name);
    // UserServiceModel findUserByUsername();
}
