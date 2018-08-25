package main;

import java.awt.Color;
import java.awt.Graphics;

public class Blocker {
	private Planet origin;
	private int angle;		//Position relative to +x (degrees)
	private int size;		//Arc angle (degrees)
	private Color col;
	
	public Blocker(Planet origin, int angle) {
		this.origin = origin;
		this.angle = angle;
		size = 60;
		col = origin.getCol().brighter();
	}
	
	public void render(Graphics g) {
		int diameter = origin.getSize()*24;
		g.setColor(col);
		g.fillArc(origin.getXPos()-diameter/2, origin.getYPos()-diameter/2, diameter, diameter, angle-size/2, size);
	}
	
	public void setAngle(int angle) {
		this.angle=angle;
		angle = angle%360;
	}
	public int getAngle() {return angle;}
	public int getSize() {return size;}
}
