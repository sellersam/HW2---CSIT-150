package HW2;

import java.util.Random;

/**
 * RandomRobot.java
 * Modified 02-26-2018
 * @author Alex Sellers
 *
 * Subclass of Robot (implementing rules for moving robots) which moves the robot at random throughout the maze.
 *
 * Algorithm:
 * 1. Generate random number (0-3) to sumbolize direction
 * 2. Test next cell in that direction
 * 3. If open, move there. If not, generate new random direction
 */
public class RandomRobot extends Robot implements MovingRobot {
    private int moveCount = 0;  // count number of moves to solve the maze

    /**
     * Constructor - passes maze to superconstructor
     * @param inMaze - maze to solve
     */
    public RandomRobot(Maze inMaze) {
        super(inMaze);
    }

    /**
     * chooseMoveDirection
     * @return direction to move
     */
    public int chooseMoveDirection() {
        Random dirGen = new Random();
        int dir;                        // direction to move
        boolean validMove = false;      // keep generating directions while false

        do {
            dir = dirGen.nextInt(4);    // generate direction

            // test direction; if valid, the loop will stop and that direction will be returned for moving
            switch (dir) {
                case 0:     // north
                    if (isValid(getRow() - 1, getCol())) validMove = true;  // if next northward cell is open,
                    break;                                                          // move there; similar for other dir
                case 1:     // south
                    if (isValid(getRow() + 1, getCol())) validMove = true;
                    break;
                case 2:     // west
                    if (isValid(getRow(), getCol() - 1)) validMove = true;
                    break;
                case 3:     //east
                    if (isValid(getRow(), getCol() + 1)) validMove = true;
                    break;
            }
        } while (!validMove);

        // increase move count
        moveCount++;

        return dir;
    }

    /**
     * toString
     * @return string containing robot type, author, and move count
     */
    public String toString() {
        return String.format("RandomRobot by Alex Sellers\nMove Count: %d\n", moveCount);
    }
}
