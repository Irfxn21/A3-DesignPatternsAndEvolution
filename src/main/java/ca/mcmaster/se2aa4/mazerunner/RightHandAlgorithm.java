package ca.mcmaster.se2aa4.mazerunner;

public class RightHandAlgorithm extends MazeSolver {
    public RightHandAlgorithm(Maze maze, Movement user) {
        super(maze, user);
    }

    protected boolean atEndCheck() {
        return user.getColumn() == maze.sizeColumn() - 1; // Method to check if end of maze
    }

    protected void move() { // Method to move around maze
        int rightRow = user.getRightRow();
        int rightColumn = user.getRightColumn();
        int nextRow = user.getNextRow();
        int nextColumn = user.getNextColumn();

        if (!maze.wallCheck(rightRow, rightColumn)) {
            user.turnRight();
            user.moveForward();
        } else if (!maze.wallCheck(nextRow, nextColumn)) {
            user.moveForward();
        } else {
            user.turnLeft();
        }
    }
}
