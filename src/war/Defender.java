package war;

public class Defender implements Warrior, Cloneable {

    private int attack = 3;
    private int health = 60;
    private int defense = 2;


    public Defender(int attack, int health, int defense) {
        this.attack = attack;
        this.health = health;
        this.defense = defense;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
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
    public void takeDamage(Warrior warrior) {
        if (warrior.getAttack() - getDefense() > 0) {
            health -= warrior.getAttack() - getDefense();
        }
    }


}
