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
                return healPower;
            }
        };
    }
}

enum PredefinedWeapon implements Weapon {

    SWORD(5, 2, 0, 0, 0),
    SHIELD(20, -1, 2, 0, 0),
    GREAT_AXE(-15, 5, -2, 10, 0),
    KATANA(-20, 6, -5, 50, 0),
    MAGIC_WAND(30, 3, 0, 0, 3);

    private final int health;
    private final int attack;
    private final int defense;
    private final int vampiring;
    private final int healPower;

    PredefinedWeapon(int health, int attack, int defense, int vampirism, int healPower) {
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.vampiring = vampirism;
        this.healPower = healPower;
    }

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
        return healPower;
    }
}
