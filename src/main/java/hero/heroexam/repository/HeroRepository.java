package hero.heroexam.repository;

import hero.heroexam.domain.entity.Classes;
import hero.heroexam.domain.entity.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroRepository extends JpaRepository<Hero, String> {
    Classes findAllByClasses(Classes heroClasses);
}
