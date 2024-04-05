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

	goCorner();
        while (true) {
            
        }
    }

public void goCorner() {
		turnRight(normalRelativeAngleDegrees(0 - getHeading()));
		// Move to that wall
		ahead(5000);
		// Turn to face the corner
		turnLeft(90);
		// Move to the corner
		ahead(5000);
		// Turn gun to starting point
		turnGunLeft(90);
	}
    
    public void onHitWall(HitWallEvent e) {
        // If hit a wall, turn left 90 degrees
        turnLeft(90);
    }
    
    public void onScannedRobot(ScannedRobotEvent e) {
        // When a robot is detected, turn towards it and shoot
	if (e.getDistance() < 50) {
        	turnGunRight(getHeading() - getGunHeading() + e.getBearing());
        	fire(2); // Adjust fire power as needed
	}
    }
