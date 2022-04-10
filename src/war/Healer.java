package war;

public class Healer extends WarriorImpl {

    private int healPower = 2;
    private int firstAid = 100;

    public Healer() {
        super(0, 60);
    }

    @Override
    public int getInitHealth() {
        return 60;
    }

    private void heal(Warrior warrior) {
        if (firstAid > 0) {
            warrior.setHealth(Math.min(warrior.getInitHealth(), warrior.getHealth() + this.healPower));
            decreaseAid();
        }
    }

    @Override
    public void hit(Warrior warrior2) {
    }

    @Override
    public void underAttack(Warrior thisWarrior) {
        heal(thisWarrior);
        if (getNext() != null) {
            getNext().underAttack(this);
        }
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        super.equipWeapon(weapon);
        this.healPower += weapon.healPower();
    }

    private void decreaseAid() {
        this.firstAid--;
    }
}
