package war;

public interface Warrior {

    enum Type {
        WARRIOR, KNIGHT
    }

    static Warrior of(Type type) {
        return switch (type) {
            case WARRIOR -> new WarriorImpl(5, 50);
            case KNIGHT -> new WarriorImpl(7, 50);
        };
    }

    int getHealth();

    int getAttack();

    boolean isAlive();

    void hit(Warrior warrior2);

    void takeDamage(Warrior warrior);
}
