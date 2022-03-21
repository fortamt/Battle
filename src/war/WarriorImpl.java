package war;

public class WarriorImpl implements Warrior {
    private int attack = 5;
    private int health = 50;

    WarriorImpl(int attack, int health) {
        this.attack = attack;
        this.health = health;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getAttack() {
        return attack;
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
        health -= warrior.getAttack();
    }

//    @Override
//    public Warrior clone() {
//        try {
//            return (Warrior) super.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//        throw new AssertionError("never should get exception"); // never should get here
//    }
}
