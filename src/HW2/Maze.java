package HW2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Character.isSpaceChar;

/**
 * Maze.java
 * Modified 02-26-2018
 * @author Alex Sellers
 *
 * Stores a maze (2D char array), as well as some information about the maze and various ways to manipulate it.
 */
public class Maze {
    private char[][] maze;
    private int rows, cols, startRow, startCol, exitRow, exitCol;

    /**
     * Constructor - reads in a maze
     * @param filename
     * @throws IOException
     */
    public Maze(File filename) throws IOException {
        Scanner mazeScan = new Scanner(filename);

        // get number of rows and columns from file, as well as start and exit positions
        rows = mazeScan.nextInt();      // number of rows in maze
        cols = mazeScan.nextInt();      // number of columns in maze
        startRow = mazeScan.nextInt();  // starting position
        startCol = mazeScan.nextInt();
        exitRow = mazeScan.nextInt();   // exit position
        exitCol = mazeScan.nextInt();
        mazeScan.nextLine();

        // create 2D char array of the size of the maze
        maze = new char[rows][cols];

        // populate each position in the maze according to input file, one line at a time
        for (int r = 0; r < rows; r++) {
            char[] currLine = mazeScan.nextLine().toCharArray();

            for (int c = 0; c < cols; c++) {
                maze[r][c] = currLine[c];
            }
        }

        // display 'r' for robot in starting position
        maze[startRow][startCol] = 'r';
    }

    /**
     * getRows - not used, but included for potential future use
     * @return number of rows in maze
     */
    public int getRows() {
        return rows;
    }

    /**
     * getCols - not used, but included for potential future use
     * @return number of columns in maze
     */
    public int getCols() {
        return cols;
    }

    /**
     * getStartRow
     * @return row containing starting position
     */
    public int getStartRow() {
        return startRow;
    }

    /**
     * getStartCol
     * @return column containing starting position
     */
    public int getStartCol() {
        return startCol;
    }

    /**
     * getExitRow - not used, but included for potential future use
     * @return row containing exit position
     */
    public int getExitRow() {
        return exitRow;
    }

    /**
     * getExitCol - not used, but included for potential future use
     * @return column containing exit position
     */
    public int getExitCol() {
        return exitCol;
    }

    /**
     * getCell - not used, but included for potential future use
     * @param row - row of cell to return
     * @param col - col of cell to return
     * @return character contained in specified cell
     */
    public char getCell(int row, int col) {
        return maze[row][col];
    }

    /**
     * openCell
     * @param row - row of cell to check
     * @param col - col of cell to check
     * @return whether or not cell is open to move to
     *      will be false if specified cell does not exist or contains anything besides a space or the start/exit
     */
    public boolean openCell(int row, int col) {
        if (row < 0 || row >= rows) return false;       // row exceeds maze size
        else if (col < 0 || col >= cols) return false;  // col exceeds maze size
        else if (isStart(row, col) || isExit(row, col)) return true; // is start or exit
        else return isSpaceChar(maze[row][col]);                     // is empty space
    }

    /**
     * setCell
     * Change the character in a specified cell to a specified character
     * @param row - row of specified cell
     * @param col - col of specified cell
     * @param newCh - new char to store in cell
     */
    public void setCell(int row, int col, char newCh) {
        maze[row][col] = newCh;
    }

    /**
     * resetCell
     * Uses setCell to change a cell back to original value once robot leaves
     * @param row - row of cell to reset
     * @param col - col of cell to reset
     */
    public void resetCell(int row, int col) {
        char newCh;

        if (isStart(row, col)) newCh = 'S'; // set char in cell to 'S' if starting position
        else newCh = ' ';                   // set char in cell to empty space if any other position

        setCell(row, col, newCh);
    }

    /**
     * isStart
     * @param row - row of cell to check
     * @param col - col of cell to check
     * @return whether or not specified cell is the starting cell
     */
    public boolean isStart(int row, int col) {
        if (row == startRow && col == startCol) return true;
        else return false;
    }

    /**
     * isExit
     * @param row - row of cell to check
     * @param col - col of cell to check
     * @return whether or not specified cell is the exit cell
     */
    public boolean isExit(int row, int col) {
        if (row == exitRow && col == exitCol) return true;
        else return false;
    }

    /**
     * toString
     * @return string containing the maze
     */
    public String toString() {
        String mazeOut = "";

        for (int r = 0; r < rows; r++) {        // add each row of maze to string
            for (int c = 0; c < cols; c++) {    // add each cell in each row
                mazeOut += maze[r][c];
            }
            mazeOut += "\n";
        }

        return mazeOut;
    }
}
