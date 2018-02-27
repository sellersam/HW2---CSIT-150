package HW2;

/**
 * MovingRobot.java (Interface)
 * Modified 02-26-2018
 * @author Alex Sellers
 *
 * Forces all moving robots to have a method for choosing a direction to move, as well as to actually move
 */
public interface MovingRobot {
    int chooseMoveDirection();
    boolean move(int direction);
}
