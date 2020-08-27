package hero.heroexam.service.Impl;

import hero.heroexam.domain.entity.Classes;
import hero.heroexam.domain.entity.Hero;
import hero.heroexam.domain.service.HeroServiceModel;
import hero.heroexam.domain.view.HeroViewModel;
import hero.heroexam.repository.HeroRepository;
import hero.heroexam.service.HeroService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HeroServiceImpl implements HeroService {
    private final ModelMapper modelMapper;
    private final HeroRepository heroRepository;

    public HeroServiceImpl(ModelMapper modelMapper, HeroRepository heroRepository) {
        this.modelMapper = modelMapper;
        this.heroRepository = heroRepository;
    }


    @Override
    public void addHero(HeroServiceModel heroServiceModel) {
        Hero hero = this.modelMapper.map(heroServiceModel, Hero.class);
        if (Classes.valueOf("warrior") == Classes.warrior) {
            hero.setClasses(Classes.warrior);
        } else if (Classes.valueOf("mage") == Classes.mage) {
            hero.setClasses(Classes.mage);
        } else {
            hero.setClasses(Classes.archer);
        }

        this.heroRepository.saveAndFlush(hero);
    }

    @Override
    public List<HeroViewModel> findAllHeroes() {
        return this.heroRepository.findAll().stream().map(hero -> {
            HeroViewModel heroViewModel = this.modelMapper.map(hero, HeroViewModel.class);

            heroViewModel.setImgUrl(String.format("/img/%s.jpg", hero.getClasses().name()));
            return heroViewModel;
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(String id) {
        this.heroRepository.deleteById(id);
    }

    @Override
    public HeroViewModel findById(String id) {
        return this.heroRepository.findById(id).map(hero -> {
            HeroViewModel heroViewModel = this.modelMapper.map(hero, HeroViewModel.class);

            heroViewModel.setImgUrl(String.format("/img/%s.jpg", hero.getClasses().name()));
            return heroViewModel;
        }).orElse(null);
    }
}
