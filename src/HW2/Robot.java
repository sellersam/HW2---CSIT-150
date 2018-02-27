package HW2;

/**
 * Robot.java (Abstract)
 * Modified 02-26-2018
 * @author Alex Sellers
 *
 * Superclass of all robots. Stores reference to the maze and contains information about the robot's position within it;
 * allows robot to move.
 */
public abstract class Robot implements MovingRobot{
    // maze and current position (row and col) of robot within it
    private Maze maze;
    private int row;
    private int col;

    /**
     * Constructor
     * @param inMaze - maze which robot will navigate
     */
    public Robot(Maze inMaze) {
        maze = inMaze;              // store reference to maze (DON'T deep copy)
        row = maze.getStartRow();   // set row to starting row
        col = maze.getStartCol();   // set col to starting col
    }

    /**
     * getRow
     * @return current row of robot
     */
    public int getRow() {
        return row;
    }

    /**
     * getCol
     * @return current col of robot
     */
    public int getCol() {
        return col;
    }

    /**
     * setRow - not used, but included for potential future use
     * @param inRow - row of new current position
     */
    public void setRow(int inRow) {
        row = inRow;
    }

    /**
     * setCol - not used, but included for potential future use
     * @param inCol - col of new current position
     */
    public void setCol(int inCol) {
        col = inCol;
    }

    /**
     * chooseMoveDirection (Abstract)
     * @return direction to move in (not used here, but in all subclasses of Robot
     */
    public abstract int chooseMoveDirection();

    /**
     * move
     * @param direction - direction to move in
     * @return boolean depending on whether or not the robot moved
     *      - note: this is not used at any point; implementation is due to the specification of the assignment
     */
    public boolean move(int direction) {
        switch (direction) {
            case 0:     // north
                maze.resetCell(row, col);   // reset current cell
                maze.setCell(row - 1, col, 'r');    // display robot in the cell it is moving to
                row--;  // move the robot (up one row when moving north, similar for other directions)
                return true;
            case 1:     // south
                maze.resetCell(row, col);
                maze.setCell(row + 1, col, 'r');
                row++;
                return true;
            case 2:     // west
                maze.resetCell(row, col);
                maze.setCell(row, col - 1, 'r');
                col--;
                return true;
            case 3:     // east
                maze.resetCell(row, col);
                maze.setCell(row, col + 1, 'r');
                col++;
                return true;
            default:
                return false;
        }
    }

    /**
     * isValid
     * @param row - row of cell to check
     * @param col - col of cell to check
     * @return whether or not the specified cell is a valid destination
     *      - note: this method simply calls Maze's method to see if destination is valid; I've implemented it this way
     *      in order to allow the position variables in Robot to remain private, as opposed to protected
     */
    public boolean isValid(int row, int col) {
        return maze.openCell(row, col);
    }

    /**
     * solved
     * @return whether or not the robot is at the exit position
     */
    public boolean solved() {
        if (maze.isExit(row, col)) return true;
        else return false;
    }
}
