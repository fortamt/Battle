package war;

public class Warrior {
    static final int ATTACK = 5;
    private int health = 50;

    int getHealth() {
        return health;
    }

    public int getAttack(){
        return ATTACK;
    }

    public boolean isAlive(){
        return getHealth() > 0;
    }

    public void hit(Warrior warrior2) {
        warrior2.takeDamage(this);
    }

    protected void takeDamage(Warrior warrior) {
        health -= warrior.getAttack();
    }
}
