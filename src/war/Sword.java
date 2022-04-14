package war;

public class Sword extends WeaponDecorator {

    public Sword(Weapon weapon) {
        super(weapon);
    }

    @Override
    public int getHealth() {
        return 5 + super.getHealth();
    }

    @Override
    public int getAttack() {
        return 2 + super.getAttack();
    }
}
