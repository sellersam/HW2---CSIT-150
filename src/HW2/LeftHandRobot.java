package HW2;

import static HW2.Facing.*;

/**
 * LeftHandRobot.java
 * Modified 02-26-2018
 * @author Alex Sellers
 *
 * Uses FacingRobot to keep track of direction the robot is facing. The robot will try to move left, then forward, then
 * right, then backward, always facing in the direction of motion. (NOTE: Very similar to RightHandRobot, except the
 * robot tries to move left and rotates right instead of left when it can't; thus see RightHandRobot for details.
 */
public class LeftHandRobot extends FacingRobot {
    private int moveCount = 0;

    /**
     * Constructor
     * @param inMaze - maze to solve
     */
    public LeftHandRobot(Maze inMaze) {
        super(inMaze);
    }

    /**
     * chooseMoveDirection
     * @return direction to move
     */
    public int chooseMoveDirection() {
        boolean validMove = false;

        do {
            switch (getFace()) {
                case NORTH:                                     // if facing north,
                    if (isValid(getRow(), getCol() - 1)) {  // try to move to the left; if it cannot be done, face
                        setFace(WEST);                          // the robot in the opposite direction so it will try
                        validMove = true;                       // to move north next time. similar for other directions
                    }
                    else setFace(EAST);
                    break;
                case SOUTH:
                    if (isValid(getRow(), getCol() + 1)) {
                        setFace(EAST);
                        validMove = true;
                    }
                    else setFace(WEST);
                    break;
                case WEST:
                    if (isValid(getRow() + 1, getCol())) {
                        setFace(SOUTH);
                        validMove = true;
                    }
                    else setFace(NORTH);
                    break;
                case EAST:
                    if(isValid(getRow() - 1, getCol())) {
                        setFace(NORTH);
                        validMove = true;
                    }
                    else setFace(SOUTH);
                    break;
            }
        } while (!validMove);

        moveCount++;

        return getFace().getDirInt();
    }

    /**
     * toString
     * @return string containing robot type, author, and move count
     */
    public String toString() {
        return String.format("LeftHandRobot by Alex Sellers\nMove Count: %d\n", moveCount);
    }
}
