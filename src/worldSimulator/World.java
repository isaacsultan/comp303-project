package worldSimulator;

/**
 * World is the class that arranges items in the grid structure, and updates the position of the itmes
 * @author isaacsultan
 */
class World {
    private final Item[][] grid;

    /**
     * Constructor of World object
     * @throws IllegalArgumentException if grid dimension is 0
     * @param numRows the number of rows the grid will take
     * @param numCols the number of columns the grid will take
     *
     */
    World(int numRows, int numCols) {
        if (numRows < 1 || numCols < 1) {
            throw new IllegalArgumentException();
        }
        grid = new Item[numRows][numCols];
    }

    /**
     * Adds an item to the world grid
     * @param item the item to add
     * @param row the position along the y axis
     * @param col the position along the x axis
     */
    public void add(Item item, int row, int col) {
        grid[row][col] = item;
    }

    /**
     * Iterates through the grid
     * If an item is autonomous, calls step and causes grid to rearrange
     * @see World#moveItem(int, int, int, char)
     */
    public void step() {

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] != null) {
                    if (grid[r][c].getToken() == 'a') {
                        char direction = ((Autonomous) grid[r][c]).step();
                        moveItem(r, c, 2, direction);
                    }
                }
            }
        }
    }


    /**
     * Checks if the autonomous item can be moved in the direction that step returns
     * If this is not possible, item will move in opposite direction
     * @see World#step()
     * @param row the position along the y axis
     * @param col the position along the x axis
     * @param k 2 -> checks intended direction, 1 -> checks opposite direction, 0 -> this item cannot move
     * @param direction specified by step
     */
    private void moveItem(int row, int col, int k, char direction) {

        boolean updated = false; //if an item is moved successfully, we no longer consider it
        char validDirection = direction;

        if (k > 0) {
            switch (validDirection) {
                case ('u'):
                    if (row == 0 || grid.length == 0) {
                        validDirection = 'd';
                        moveItem(row, col, k - 1, validDirection);
                    } else {
                        for (int r = row; r >= 0; r--) {

                            if (grid[r][col] == null) {
                                updated = moveItemHelper(row, col, validDirection, r);
                                break;
                            } else if (grid[r][col].getToken() == 'i') {
                                validDirection = 'd';
                                moveItem(row, col, k - 1, validDirection);
                            }
                        }
                    }
                    break;
                case ('d'):
                    if (grid.length == 0 || (row == grid.length - 1)) {
                        moveItem(row, col, k - 1, 'u');
                    } else {
                        for (int r = row; r < grid.length; r++) {

                            if (grid[r][col] == null) {
                                updated = moveItemHelper(row, col, validDirection, r);
                                break;
                            } else if (grid[r][col].getToken() == 'i') {
                                validDirection = 'u';
                                moveItem(row, col, k - 1, validDirection);
                            }
                        }
                    }
                    break;
                case ('r'):
                    if (grid[0].length == 0 || (col == grid[0].length - 1)) {
                        validDirection = 'l';
                        moveItem(row, col, k - 1, validDirection);
                    } else {
                        for (int c = col; c < grid[0].length; c++) {

                            if (grid[row][c] == null) {
                                updated = moveItemHelper(row, col, validDirection, c);
                                break;
                            } else if (grid[row][col].getToken() == 'i') {
                                validDirection = 'l';
                                moveItem(row, col, k - 1, validDirection);
                            }
                        }
                    }
                    break;
                case ('l'):
                    if (col == 0 || grid[0].length == 0) {
                        moveItem(row, col, k - 1, direction);
                    } else {
                        for (int c = col; c >= 0; c--) {

                            if (grid[row][c] == null) {
                                updated = moveItemHelper(row, col, validDirection, c);
                                break;
                            }
                            if (grid[row][col].getToken() == 'i') {
                                validDirection = 'r';
                                moveItem(row, col, k - 1, validDirection);
                            }
                        }
                    }
                    break;
            }
            if (!updated) {
                moveItem(row, col, k - 1, direction);
            }

        }
    }

    /**
     * Switches positions of items
     * Iterates along the row/col in question (according to direction) up until the stopValue
     * Can move more than one item, in a chain reaction (up until reaches an edge
     * @param row y axis of first item to move
     * @param col x axis of first item to move
     * @param direction direction to move along
     * @param stopValue prevents null pointer exception (we check every item until null)
     * @return true when a sucessful update(s) occurs
     */
    private boolean moveItemHelper(int row, int col, char direction, int stopValue) {
        Item temp = grid[row][col];
        grid[row][col] = null;
        Item tempNext;

        switch (direction) {
            case ('u'):
                for (int r = row - 1; r >= stopValue; r--) {
                    tempNext = this.grid[r][col];
                    temp.setCoordinates(r, col);
                    this.grid[r][col] = temp;
                    temp = tempNext;

                }
                break;
            case ('d'):
                for (int r = row + 1; r <= stopValue; r++) {
                    tempNext = this.grid[r][col];
                    temp.setCoordinates(r, col);
                    this.grid[r][col] = temp;
                    temp = tempNext;

                }
                break;
            case ('r'):
                for (int c = col + 1; c <= stopValue; c++) {
                    tempNext = this.grid[row][c];
                    temp.setCoordinates(row, c);
                    this.grid[row][c] = temp;
                    temp = tempNext;

                }
                break;
            case ('l'):
                for (int c = col - 1; c >= stopValue; c--) {
                    tempNext = this.grid[row][c];
                    temp.setCoordinates(row, c);
                    this.grid[row][c] = temp;
                    temp = tempNext;
                }
                break;
        }
        return true;
    }

    /**
     * Displays the whole grid with the items inside as a single string
     * @param iteration to print the iteration of the simulation
     * @return string of grid
     */
    public String display(int iteration) {

        StringBuilder text = new StringBuilder("Iteration: " + iteration + "\n");
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (this.grid[r][c] == null) {
                    text.append("-");
                } else {
                    text.append(this.grid[r][c].getToken()).append(" ");
                }
            }
            text.append("\n");
        }
        return text.toString();
    }
}
