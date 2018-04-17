package worldSimulator;

import java.util.Random;

/**
 * Autonomous item can move by itself
 * @author isaacsultan
 */
class Autonomous extends Item {

    /**
     * Autonomous constructor
     * NB: sets name and token by calling super-class
     */
    Autonomous() {
        super("autonomous", 'a');
    }

    /**
     * chooses a direction to step in
     * @return a char {'u', 'd', 'r', 'l'} corresponding to direction
     */
    public char step() {
        Random random = new Random();
        char[] directions = {'u', 'd', 'r', 'l'};
        return directions[random.nextInt(3)];
    }


}
