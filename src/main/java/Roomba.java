import robocode.*;
//import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * Roomba - a robot by (your name here)
 */
public class Roomba extends Robot
{
	/**
	 * run: Roomba's default behavior
	 */
	public void run() {
		setBodyColor(java.awt.Color.black);
        setGunColor(java.awt.Color.red);
        setRadarColor(java.awt.Color.red);
        setBulletColor(java.awt.Color.yellow);
        setScanColor(java.awt.Color.red);

		// Robot main loop
		while(true) {
			turnRadarRight(360);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
     public void onScannedRobot(ScannedRobotEvent e) {
	if (e.getName() == "LuckyBot") {
        	double bearing = e.getBearing();
        	double distance = e.getDistance();
        
        	turnRight(bearing);
        
        	ahead(distance / 2);
        
        	double radarTurn = getHeadingRadians() + e.getBearingRadians() - getRadarHeadingRadians();
        	setTurnRadarRightRadians(2.0 * Math.PI * Utils.normalRelativeAngle(radarTurn));
        
        	fire(1); 

	}
    }

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		back(30);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		back(30);
	}	
}
