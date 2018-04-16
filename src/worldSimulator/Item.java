package worldSimulator;

class Item {
    private final char token;
    private int x;
    private int y;
    private String name;

    Item(String name, char token) {
        this.name = name;
        this.token = token;
    }

    public char getToken() {
        return this.token;
    }

    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return token + "   ";
    }
}

