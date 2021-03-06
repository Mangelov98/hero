package hero.heroexam.domain.view;

import hero.heroexam.domain.entity.Classes;

public class HeroViewModel {

    private String id;
    private String heroName;
    private String imgUrl;
    private Classes heroClass;
    private int level;

    public HeroViewModel() {
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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



