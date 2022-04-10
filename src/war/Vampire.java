package war;

public class Vampire extends WarriorImpl {

    private int vampiring = 50;
    private int initHealth = 40;

    public Vampire() {
        super(4, 40);
    }

    public int getVampiring() {
        return vampiring;
    }

    @Override
    public int getInitHealth() {
        return initHealth;
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
        this.vampiring += weapon.getVampiring();
        this.initHealth = this.getHealth();
    }
}
