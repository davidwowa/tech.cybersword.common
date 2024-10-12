package tech.cybersword.mouse;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;

public class M {

	public static void main(String[] args) {
		try {
			Robot robot = new Robot();
			Point p;

			while (true) {
				p = MouseInfo.getPointerInfo().getLocation();
				robot.mouseMove(p.x + 5, p.y + 5);
				robot.delay(5000);
				robot.mouseMove(p.x - 5, p.y - 5);
				robot.delay(500);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}