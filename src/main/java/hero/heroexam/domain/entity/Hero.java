package hero.heroexam.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "heroes")
public class Hero extends BaseEntity {

    private String heroName;
    private Classes heroClass;
    private int level;

    public Hero() {
    }

    @Column(name = "heroName", nullable = false, unique = true)
    public String getName() {
        return heroName;
    }

    public void setName(String heroName) {
        this.heroName = heroName;
    }

    @Enumerated(value = EnumType.STRING)
    public Classes getClasses() {
        return heroClass;
    }

    public void setClasses(Classes heroClass) {
        this.heroClass = heroClass;
    }

    @Column(name = "level", nullable = false)
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
