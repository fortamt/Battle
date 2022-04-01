package war;

public class Healer extends WarriorImpl {

    private final int HEAL = 2;
    private int firstAid = 100;

    public Healer() {
        super(0, 60);
    }

    @Override
    public int getInitHealth() {
        return 60;
    }

    private void heal(WarriorImpl warrior) {
        if (firstAid > 0) {
            warrior.setHealth(Math.min(getInitHealth(), getHealth() + this.HEAL));
            decreaseAid();
        }
    }

    @Override
    public void hit(Warrior warrior2) {
        underAttack(this);
    }

    @Override
    public void underAttack(WarriorImpl thisWarrior) {
        heal(thisWarrior);
        if (getNext() != null) {
            getNext().underAttack(this);
        }
    }

    private void decreaseAid() {
        this.firstAid--;
    }
}
