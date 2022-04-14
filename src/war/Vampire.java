package war;

public class Vampire extends WarriorImpl {

    static int initialHealth = 40;
    private int vampiring = 50;

    public Vampire() {
        super(4, 40);
    }

    private int getVampiring() {
        return vampiring;
    }

    @Override
    public int getInitHealth() {
        return Math.max(0,
                initialHealth + weapons.stream()
                        .mapToInt(Weapon::getHealth)
                        .sum());
    }

    @Override
    public void hit(Warrior warrior2) {
        var healthBefore = warrior2.getHealth();
        warrior2.takeDamage(this);
        var heal = (healthBefore - warrior2.getHealth()) * getVampiring() / 100;
        var vampireHealth = this.getHealth() + heal;
        setHealth(Math.min(vampireHealth, getInitHealth()));
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        super.equipWeapon(weapon);
        setVampiring(getVampiring() + weapon.getVampiring());
    }

    private void setVampiring(int vampiring) {
        this.vampiring = vampiring;
    }
}
