package HW2;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Homework #2 Answers:		(Alex Sellers)
 * 1. 	C
 * 2. 	A
 * 3. 	A
 * 4. 	A
 * 5, 	A
 * 6. 	A (It's overriding only if the signatures are identical)
 * 7. 	B (Not in the same class)
 * 8. 	B (Protected fields can be accessed throughout the package
 * 9. 	D
 * 10.	C
 * 11.	A
 * 12.	B
 * 13.	A
 * 14.	B
 * 15.	A
 * 16. 	A
 * 17.	B
 * 18.	public abstract class Vehicle {		//super class (MUST be abstract if contains abstract methods
 *     		public abstract double getMilesPerGallon();
 *     		//Other methods...
 * 		}
 *
 * 		public class Car extends Vehicle {	//sub class
 * 		    private int mpg;
 * 		    public double getMilesPerGallon() {	//no semicolon needed here; overriding method cannont return a different
 * 		        return Double.parseDouble(mpg);		//primitive data type from superclass method
 * 		    }
 * 		}
 */

/**
 * This program simulates a robot getting through a maze.
 *	Unlike tic-tac-toe, where the user is the player, the robot moves 
	autonomously through the maze.
 * 	We intentionally share the memory location of the maze with the robot.
	Otherwise the robot would not know how to plan and make its moves.
	
	The maze is stored in a text file that will be entered at runtime.  
	The layout of each maze file will contain:
�	In the first line:  two integers (the number of rows and columns, respectively,  in the maze)  
�	In the second line:  two integers (the row and column locations, respectively, of the Start cell
�	In the third line:  two integers (the row and column locations, respectively, of the Exit cell
�	Each line thereafter will contain characters appearing in one row of the maze.  

 * Created by Sherri Harms (slight modification on bot seletion and result display by Alex Sellers)
 * built on top of Eddy's UW-Parkside solution
 */

public class MazeDriver {

	public static void main(String[] args) throws IOException {
		File inputFile = getFile();  //sample: testmaze.txt
		Maze maze = new Maze(inputFile);
		Robot bot;
		System.out.println(maze);
		//allow user to select bot type
		String botType = JOptionPane.showInputDialog("Select bot type. 1 for Random, 2 for Left Hand, " +
				"or anything else for Right Hand.\n");

		if (botType.equals("1")) bot = new RandomRobot(maze);//this ties the robot to the maze it is in
		else if (botType.equals("2")) bot = new LeftHandRobot(maze);
		else bot = new RightHandRobot(maze);

		for (int k = 0; k < 1000000 && !bot.solved(); k++)
		//this limits the robot's moves, in case it takes too long to find the exit.
		{
			int direction = bot.chooseMoveDirection();
			if (direction >=0)  //invalid direction is -1
				bot.move(direction);
			System.out.println(maze);
			System.out.println("\n");
		}

		//display bot type and move count
		System.out.println(bot);
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
