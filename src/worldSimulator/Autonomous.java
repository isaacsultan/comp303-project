package worldSimulator;

import java.util.Random;

class Autonomous extends Item {

    public Autonomous() {
        super("autonomous", 'a');
    }

    public char step() {
        Random random = new Random();
        char[] directions = {'u', 'd', 'r', 'l'};
        return directions[random.nextInt(3)];
    }


}
