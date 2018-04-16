package worldSimulator;

class World {
    private final Item[][] grid;
    private int stopValue;
    private char direction;


    public World(int numRows, int numCols) {
        stopValue = -1;
        grid = new Item[numRows][numCols];
    }

    public void add(Item o, int rowIndex, int colIndex) {
        grid[rowIndex][colIndex] = o;
    }

    public void step() {

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] != null) {
                    if (grid[r][c].getToken() == 'a') {
                        char direction = ((Autonomous) grid[r][c]).step();
                        validateDirection(r, c, 2,direction);
                        }
                    }
                }
            }
        }



    private void validateDirection(int row, int col, int k, char direction) {
        boolean updated = false;
        if (k > 0) {
            switch (direction) {
                case ('u'):
                    if (row == 0 || grid.length == 0) {
                        validateDirection(row, col, k-1, 'd');
                    } else {
                        for (int r = row; r >= 0; r--) {

                            if (grid[r][col] == null) {
                                stopValue = r;
                                updated = update(row, col, 'u' );
                                break;
                            } else if (grid[r][col].getToken() == 'i') {
                                validateDirection(row, col, k-1, 'd');
                            }
                        }
                    }
                    break;
                case ('d'):
                    if (grid.length == 0 || (row == grid.length - 1)) {
                        validateDirection(row, col, k-1, 'u');
                    } else {
                        for (int r = row; r < grid.length; r++) {

                            if (grid[r][col] == null) {
                                stopValue = r;
                                updated = update(row, col, 'd' );
                                break;
                            } else if (grid[r][col].getToken() == 'i') {
                                validateDirection(row, col, k-1, 'u');
                            }
                        }
                    }
                    break;
                case ('r'):
                    if (grid[0].length == 0 || (col == grid[0].length - 1)) {
                        validateDirection(row, col, k-1, 'l');
                    } else {
                        for (int c = col; c < grid[0].length; c++) {
                            if (grid[row][c] == null) {
                                stopValue = c;
                                updated =  update(row, col, 'r' );
                                break;
                            } else if (grid[row][col].getToken() == 'i') {
                                validateDirection(row, col, k-1, 'l');
                            }
                        }
                    }
                    break;
                case ('l'):
                    if (col == 0 || grid[0].length == 0) {
                        validateDirection(row, col, k-1, 'l');
                    } else {
                        for (int c = col; c >= 0; c--) {
                            if (grid[row][c] == null) {
                                stopValue = c;
                                updated = update(row, col, 'l');
                                break;
                            }
                            if (grid[row][col].getToken() == 'i') {
                                validateDirection(row, col, k-1, 'r');
                            }
                        }
                    }
                    break;
            }
            if (!updated) {
                validateDirection(row, col, k - 1, direction);
            }

        }
    }

    private boolean update(int row, int col, char direction) {
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
