package war;

public interface Weapon {

    int getHealth();

    int getAttack();

    int getDefense();

    int getVampiring();

    int healPower();

    static Weapon customizedWeapon(int health, int attack, int defense, int vampiring, int healPower) {
        return new Weapon() {

            @Override
            public int getHealth() {
                return health;
            }

            @Override
            public int getAttack() {
                return attack;
            }

            @Override
            public int getDefense() {
                return defense;
            }

            @Override
            public int getVampiring() {
                return vampiring;
            }

            @Override
            public int healPower() {
                return health;
            }
        };
    }

}


