package hw2sp14;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


/**
 * This program simulates a robot getting through a maze.
 *	Unlike tic-tac-toe, where the user is the player, the robot moves 
	autonomously through the maze.
 * 	We intentionally share the memory location of the maze with the robot.
	Otherwise the robot would not know how to plan and make its moves.
	
	The maze is stored in a text file that will be entered at runtime.  
	The layout of each maze file will contain:
•	In the first line:  two integers (the number of rows and columns, respectively,  in the maze)  
•	In the second line:  two integers (the row and column locations, respectively, of the Start cell
•	In the third line:  two integers (the row and column locations, respectively, of the Exit cell
•	Each line thereafter will contain characters appearing in one row of the maze.  

 * Created by Sherri Harms
 * built on top of Eddy's UW-Parkside solution
 */

public class MazeDriver {

	public static void main(String[] args) throws IOException {
		File inputFile = getFile();  //sample: testmaze.txt
		Maze maze = new Maze(inputFile);
		System.out.println(maze);
		Robot bot = new RightHandRobot(maze);//this ties the robot to the maze it is in

		for (int k = 0; k < 1000000 && !bot.solved(); k++) 
		//this limits the robot's moves, in case it takes too long to find the exit.
		{
			int direction = bot.chooseMoveDirection();
			if (direction >=0)  //invalid direction is -1
				bot.move(direction);
			System.out.println(maze);
			System.out.println("\n");
		}
	}
	
	/**
	 * Get the file that has the maze specifications.
	 * @return File chosen by user.
	 */
	public static File getFile()
	{
		JFileChooser chooser;
		try{

			// Get the filename.
			chooser = new JFileChooser();
			int status = chooser.showOpenDialog(null);
			if (status != JFileChooser.APPROVE_OPTION)
			{
				System.out.println("No File Chosen");
				System.exit(0);
			}
			return chooser.getSelectedFile();
		} catch (Exception e)
		{
			System.out.println("Exception: " + e.getMessage());
			System.exit(0);

		}
		return null; //should never get here, but makes compiler happy
	}

}
