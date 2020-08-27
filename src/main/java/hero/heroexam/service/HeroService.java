package hero.heroexam.service;

import hero.heroexam.domain.service.HeroServiceModel;
import hero.heroexam.domain.view.HeroViewModel;

import java.util.List;

public interface HeroService {

    void addHero(HeroServiceModel heroServiceModel);

    List<HeroViewModel> findAllHeroes();

    void delete(String id);

    HeroViewModel findById(String id);
}
