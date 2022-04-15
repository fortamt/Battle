package war;

public class Healer extends WarriorImpl {

    static int initialHealth = 60;
    private int healPower = 2;
    private int firstAid = 100;

    public Healer() {
        super(0, 60);
    }

    @Override
    public int getInitHealth() {
        return initialHealth;
    }

    private void heal(Warrior warrior) {
        if (firstAid > 0) {
            warrior.setHealth(Math.min(warrior.getInitHealthWithModifier(), warrior.getHealth() + this.healPower));
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
        setHealPower(getHealPower() + weapon.healPower());
    }

    private int getHealPower() {
        return healPower;
    }

    private void setHealPower(int healPower) {
        this.healPower = healPower;
    }

    private void decreaseAid() {
        this.firstAid--;
    }
}
