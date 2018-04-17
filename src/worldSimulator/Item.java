package worldSimulator;

/**
 * Super class of objects within simulator
 * @author isaacsultan
 */
abstract class Item {
    private final char token;
    private int row;
    private int col;
    private String name;

    /**
     * Item constructor
     * @param name name of item
     * @param token character corresponding to item type
     */
    Item(String name, char token) {
        this.name = name;
        this.token = token;
    }

    /**
     * Getter method
     * @return token character
     */
    public char getToken() {
        return this.token;
    }

    /**
     * Setter method
     * @param row position in y axis
     * @param col position in x axis
     */
    public void setCoordinates(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Overrided for pretty print
     * @return string of token of each item
     */
    @Override
    public String toString() {
        return token + "   ";
    }
}

