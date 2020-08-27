package hero.heroexam.domain.service;

import hero.heroexam.domain.entity.Classes;

public class HeroServiceModel extends BaseServiceModel {

    private String heroName;
    private Classes heroClass;
    private int level;

    public HeroServiceModel() {
    }

    public String getName() {
        return heroName;
    }

    public void setName(String heroName) {
        this.heroName = heroName;
    }

    public Classes getClasses() {
        return heroClass;
    }

    public void setClasses(Classes heroClass) {
        this.heroClass = heroClass;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
