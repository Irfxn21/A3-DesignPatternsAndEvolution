package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MazeTest {

    @Test
    public void testEntryPoint() {
        char[][] grid = {
                { '#', '#', '#', '#' },
                { '#', '#', '#', '#' },
                { ' ', ' ', '#', '#' },
                { '#', ' ', ' ', ' ' },
                { '#', '#', '#', '#' }
        };
        Maze maze = new RightHandAlgo(grid);
        assertEquals(2, maze.getStartRow());
        assertEquals(0, maze.getStartColumn());
    }

    @Test
    public void testWallCheck() {
        char[][] grid = {
                { '#', '#', '#', '#' },
                { '#', '#', '#', '#' },
                { ' ', ' ', '#', '#' },
                { '#', ' ', ' ', ' ' },
                { '#', '#', '#', '#' }
        };
        Maze maze = new RightHandAlgo(grid);
        assertTrue(maze.wallCheck(2, 2));
        assertFalse(maze.wallCheck(2, 1));
    }

    @Test
    public void testNextTileCoord() {
        Movement movement = new Movement(2, 3);
        assertEquals(2, movement.getNextRow());
        assertEquals(4, movement.getNextColumn());
    }

    @Test
    public void testRightTileCoord() {
        Movement movement = new Movement(2, 3);
        assertEquals(3, movement.getRightRow());
        assertEquals(3, movement.getRightColumn());
    }

    @Test
    public void testMovementForward() {
        Movement movement = new Movement(1, 1);
        movement.moveForward();
        assertEquals(1, movement.getRow());
        assertEquals(2, movement.getColumn());
    }

    @Test
    public void testTurnRight() {
        Movement movement = new Movement(1, 1);
        movement.turnRight();
        assertEquals('S', movement.direction);
    }

    @Test
    public void testTurnLeft() {
        Movement movement = new Movement(1, 1);
        movement.turnLeft();
        assertEquals('N', movement.direction);
    }

    @Test
    public void testCorrectPathVerificationCorrect() {
        char[][] grid = {
                { '#', '#', '#', '#' },
                { '#', '#', '#', '#' },
                { ' ', ' ', '#', '#' },
                { '#', ' ', ' ', ' ' },
                { '#', '#', '#', '#' }
        };
        Maze maze = new RightHandAlgo(grid);
        Movement movement = new Movement(2, 0);
        PathChecker pathChecker = new PathChecker(maze, movement);
        assertTrue(pathChecker.verifyPath("FRFLFF"));
    }

    @Test
    public void testIncorrectPathVerification() {
        char[][] grid = {
                { '#', '#', '#', '#' },
                { '#', '#', '#', '#' },
                { ' ', ' ', '#', '#' },
                { '#', ' ', ' ', ' ' },
                { '#', '#', '#', '#' }
        };
        Maze maze = new RightHandAlgo(grid);
        Movement movement = new Movement(0, 0);
        PathChecker pathChecker = new PathChecker(maze, movement);
        assertFalse(pathChecker.verifyPath("FF"));
    }

    @Test
    public void testCanonicalPathConversion() {
        PathChecker pathChecker = new PathChecker(null, null);
        assertEquals("FFFF", pathChecker.expandPath("4F"));
        assertEquals("RRRLL", pathChecker.expandPath("3R2L"));
    }
}
