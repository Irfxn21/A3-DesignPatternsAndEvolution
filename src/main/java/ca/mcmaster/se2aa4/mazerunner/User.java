package ca.mcmaster.se2aa4.mazerunner;

public abstract class User { // Abstract class

    // Attributes
    protected int row;
    protected int column;
    protected char direction = 'E'; // Initial direction set East

    public User(int row, int column) {
        this.row = row;
        this.column = column; // Constructors
    }

    public int getRow() {
        return row; // Get row of current postion
    }

    public int getColumn() {
        return column; // Get column of current postion
    }

    public int getNextRow() { // Get row value of next tile
        if (direction == 'N') {
            return row - 1;
        }
        if (direction == 'S') {
            return row + 1;
        }
        return row;
    }

    public int getNextColumn() { // Get column value of next tile
        if (direction == 'E') {
            return column + 1;
        }
        if (direction == 'W') {
            return column - 1;
        }
        return column;
    }

    public int getRightRow() { // Get row value of right tile
        if (direction == 'N' || direction == 'S') {
            return row;
        }
        if (direction == 'E') {
            return row + 1;
        }
        return row - 1;
    }

    public int getRightColumn() { // Get column value of right column
        if (direction == 'E' || direction == 'W') {
            return column;
        }
        if (direction == 'N') {
            return column + 1;
        }
        return column - 1;
    }

    public abstract void moveForward();

    public abstract void turnRight();

    public abstract void turnLeft();

    public abstract void displayPath(); // Abstract methods
}