package hero.heroexam.domain.binding;

import hero.heroexam.domain.entity.Classes;

public class HeroDeleteBindingModel {

    private String id;
    private String heroName;
    private Classes heroClass;
    private int level;

    public HeroDeleteBindingModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public Classes getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(Classes heroClass) {
        this.heroClass = heroClass;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
