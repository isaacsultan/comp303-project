package worldSimulator;

/**
 * Immovable class cannot be moved, or move
 */
class Immovable extends Item {

    /**
     * Immovable constructor
     * NB: sets name and token by calling super-class
     */
    Immovable() {
        super("immovable", 'i');
    }
}

