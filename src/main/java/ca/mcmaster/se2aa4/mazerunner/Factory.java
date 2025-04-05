package ca.mcmaster.se2aa4.mazerunner;

public class Factory {

    public static Maze createMaze(char[][] grid) {
        return new Maze(grid);
    }

    public static Movement createMovement(int row, int col) {
        return new Movement(row, col);
    }

    public static PathChecker createPathChecker(Maze maze, Movement movement) {
        return new PathChecker(maze, movement);
    }
}
