package HW2;

/**
 * Facing (Enum)
 * Modified 02-22-2018
 * @author Alex Sellers
 *
 * Enumerative type used to keep track of direction any given robot is facing; dirInt is used to choose direction and
 * move the robot.
 */
public enum Facing {
    NORTH (0),  // can face north, south, west, or east
    SOUTH (1),
    WEST (2),
    EAST (3);

    private final int dirInt;   // used for moving methods

    /**
     * Initialize dirInt for each direction
     * @param dirInt - integer representing direction
     */
    Facing(int dirInt) {
        this.dirInt = dirInt;
    }

    /**
     * getDirInt
     * @return dirInt to be used in moving methods
     */
    public int getDirInt() {
        return dirInt;
    }
}
