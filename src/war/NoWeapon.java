package war;

public class NoWeapon implements Weapon {

    @Override
    public int getHealth() {
        return 0;
    }

    @Override
    public int getAttack() {
        return 0;
    }

    @Override
    public int getDefense() {
        return 0;
    }

    @Override
    public int getVampiring() {
        return 0;
    }

    @Override
    public int healPower() {
        return 0;
    }
}
