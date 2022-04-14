package war;

public class Shield extends WeaponDecorator {

    public Shield(Weapon weapon) {
        super(weapon);
    }

    @Override
    public int getHealth() {
        return 20;
    }

    @Override
    public int getAttack() {
        return -1;
    }

    @Override
    public int getDefense() {
        return 2;
    }
}
