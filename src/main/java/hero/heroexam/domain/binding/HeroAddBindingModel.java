package hero.heroexam.domain.binding;

import hero.heroexam.domain.entity.Classes;
import org.hibernate.validator.constraints.Length;

public class HeroAddBindingModel {
    private String heroName;
    private Classes heroClass;
    private int level;

    public HeroAddBindingModel() {
    }

    @Length(min = 2, message = "Username length must be more than two characters!")
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
