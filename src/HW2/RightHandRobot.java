package HW2;

import static HW2.Facing.*;

/**
 * RightHandRobot.java
 * Modified 02-22-2018
 * @author Alex Sellers
 *
 * Uses FacingRobot to keep track of direction the robot is facing. The robot will try to move right, then forward, then
 * left, then backward, always facing in the direction of motion.
 */
public class RightHandRobot extends FacingRobot {
    private int moveCount = 0;  // track move count

    /**
     * Constructor
     * @param inMaze - maze to solve
     */
    public RightHandRobot(Maze inMaze) {
        super(inMaze);
    }

    /**
     * chooseMoveDirection
     * @return direction to move
     */
    public int chooseMoveDirection() {
        boolean validMove = false;  // keep trying directions until one is found (no more than four will ever be tried)

        do {
            switch (getFace()) {
                case NORTH:                                     // if the robot is facing north,
                    if (isValid(getRow(), getCol() + 1)) {  // see if the robot can move to the right (east)
                        setFace(EAST);                          // if so, choose east as direction to face (and thus
                        validMove = true;                       // move after the loop) and end the loop
                    }
                    else setFace(WEST);                         // if the robot can't move to the right, turn to the
                    break;                  // left (west) to test north next iteration (similar for each direction)
                case SOUTH:
                    if (isValid(getRow(), getCol() - 1)) {
                        setFace(WEST);
                        validMove = true;
                    }
                    else setFace(EAST);
                    break;
                case WEST:
                    if (isValid(getRow() - 1, getCol())) {
                        setFace(NORTH);
                        validMove = true;
                    }
                    else setFace(SOUTH);
                    break;
                case EAST:
                    if(isValid(getRow() + 1, getCol())) {
                        setFace(SOUTH);
                        validMove = true;
                    }
                    else setFace(NORTH);
                    break;
            }
        } while (!validMove);

        // increase move count
        moveCount++;

        // the robot will move in the direction it is facing at the end of the loop, thus it will be facing in the
        return getFace().getDirInt();   // correct direction the next time a move is chosen
    }

    /**
     * toString
     * @return string containing robot type, author, and move count
     */
    public String toString() {
        return String.format("RightHandRobot by Alex Sellers\nMove Count: %d\n", moveCount);
    }
}
