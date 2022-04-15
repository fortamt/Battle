package war;

import java.util.ArrayList;
import java.util.List;

public class WarriorImpl implements Warrior {
    static int initialHealth = 50;
    private final int attack;
    private int health;
    private final List<Weapon> weapons = new ArrayList<>();

    private Warrior nextBehind = null;

    WarriorImpl(int attack, int health) {
        this.attack = attack;
        this.health = health;
    }

    @Override
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = Math.min(getInitHealthWithModifier(), health);
    }

    @Override
    public int getAttack() {
        return attack + weapons.stream()
                .mapToInt(Weapon::getAttack)
                .sum();
    }

    @Override
    public boolean isAlive() {
        return getHealth() > 0;
    }

    @Override
    public void hit(Warrior warrior2) {
        warrior2.takeDamage(this);
    }

    @Override
    public void takeDamage(HasAttack warrior) {
        if (warrior.getAttack() > 0) {
            health -= warrior.getAttack();
        }
        underAttack(this);
    }

    @Override
    public void setNext(Warrior nextBehind) {
        this.nextBehind = nextBehind;
    }

    @Override
    public Warrior getNext() {
        return nextBehind;
    }

    @Override
    public int getInitHealth() {
        return initialHealth;
    }

    @Override
    public int getInitHealthWithModifier() {
        return Math.max(0,
                getInitHealth() + weapons.stream()
                        .mapToInt(Weapon::getHealth)
                        .sum());
    }

    @Override
    public void underAttack(Warrior thisWarrior) {
        if (getNext() != null) {
            getNext().underAttack(this);
        }
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        weapons.add(weapon);
        setHealth(getHealth() + weapon.getHealth());
    }
}
