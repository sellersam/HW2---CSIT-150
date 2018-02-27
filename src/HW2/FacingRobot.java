package HW2;

import static HW2.Facing.*;

/**
 * FacingRobot.java (Abstract)
 * Modified 02-26-2018
 * @author Alex Sellers
 *
 * Abstract class to keep track of the direction the robot (child class RightHandRobot or LeftHandRobot) is facing
 */
public abstract class FacingRobot extends Robot implements MovingRobot {
    private Facing face;    // use enum Facing to store direction

    /**
     * Constructor - pass maze to navigate to superconstructor, initialize direction to south (all mazes start at top)
     * @param inMaze - maze to solve
     */
    public FacingRobot(Maze inMaze) {
        super(inMaze);
        face = SOUTH;
    }

    /**
     * getFace
     * @return direction robot is facing (Facing enum type)
     */
    public Facing getFace() {
        return face;
    }

    /**
     * setFace
     * @param inFace - new direction (enum Facing) that the robot is facing
     */
    public void setFace(Facing inFace) {
        face = inFace;
    }
}
