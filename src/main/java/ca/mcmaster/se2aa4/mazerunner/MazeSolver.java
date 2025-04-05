package ca.mcmaster.se2aa4.mazerunner;

public abstract class MazeSolver {
    protected Maze maze;
    protected Movement user;

    public MazeSolver(Maze maze, Movement user) {
        this.maze = maze;
        this.user = user;
    }

    public void solve() {
        while (!atEndCheck()) {
            move();
        }
        user.displayPath();
    }

    protected abstract boolean atEndCheck();

    protected abstract void move();
}
