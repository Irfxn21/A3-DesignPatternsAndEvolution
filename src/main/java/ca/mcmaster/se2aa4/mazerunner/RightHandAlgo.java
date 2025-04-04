package ca.mcmaster.se2aa4.mazerunner;

public class RightHandAlgo extends Maze {

    public RightHandAlgo(char[][] grid) {
        super(grid);
    }

    public void playMaze(Movement user) { // Method to iterate through maze
        while (user.getColumn() != columns - 1) {
            int rightRow = user.getRightRow();
            int rightColumn = user.getRightColumn();
            int nextRow = user.getNextRow();
            int nextColumn = user.getNextColumn();

            if (!wallCheck(rightRow, rightColumn)) { // implementation of right hand algorithm
                user.turnRight();
                user.moveForward();
            } else if (!wallCheck(nextRow, nextColumn)) {
                user.moveForward();
            } else {
                user.turnLeft();
            }
        }
        user.displayPath();// Display factorized path
    }
}
