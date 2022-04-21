package war;

public class Warlord extends Defender {

    static int initialHealth = 100;

    Warlord() {
        super(4, 100, 2);
    }

    @Override
    public int getInitHealth() {
        return initialHealth;
    }


}
