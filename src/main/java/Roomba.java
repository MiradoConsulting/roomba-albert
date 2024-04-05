import robocode.*;
//import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * Roomba - a robot by (your name here)
 */
public class Roomba extends Robot
{

 public void run() {
		setBodyColor(java.awt.Color.black);
        setGunColor(java.awt.Color.red);
        setRadarColor(java.awt.Color.red);
        setBulletColor(java.awt.Color.yellow);
        setScanColor(java.awt.Color.red);

        while (true) {
            // Move along the wall
            ahead(100);
            turnRight(90);
        }
    }
    
    public void onHitWall(HitWallEvent e) {
        // If hit a wall, turn left 90 degrees
        turnLeft(90);
    }
    
    public void onScannedRobot(ScannedRobotEvent e) {
        // When a robot is detected, turn towards it and shoot
        turnGunRight(getHeading() - getGunHeading() + e.getBearing());
        fire(1); // Adjust fire power as needed
    }
