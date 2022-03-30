package war;

public class WarriorImpl implements Warrior {
    private int attack = 5;
    private int health = 50;

    private Warrior nextBehind = null;

    WarriorImpl(int attack, int health) {
        this.attack = attack;
        this.health = health;
    }

    @Override
    public int getHealth() {
        return health;
    }

    protected void setHealth(int health) {
        this.health = health;
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
        underAttack(this);
    }

    @Override
    public void takeDamage(HasAttack warrior) {
        health -= warrior.getAttack();
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
        return 50;
    }

    @Override
    public void underAttack(WarriorImpl thisWarrior) {
        if (getNext() != null) {
            getNext().underAttack(this);
        }
    }
}
