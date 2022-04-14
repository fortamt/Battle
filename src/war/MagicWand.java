package war;

public class MagicWand extends WeaponDecorator {

    public MagicWand(Weapon weapon) {
        super(weapon);
    }

    @Override
    public int getHealth() {
        return 30;
    }

    @Override
    public int getAttack() {
        return 3;
    }

    @Override
    public int healPower() {
        return 3;
    }
}
