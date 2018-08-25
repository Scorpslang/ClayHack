package main;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	private int xPos, yPos;
	private int xVel, yVel;
	private Color col;
	private int size; 		//1-10
	
	public Ball(int xPos, int yPos, int xVel, int yVel, Color col, int size) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.xVel = xVel;
		this.yVel = yVel;
		this.col = col;
		this.size = size;
	}
	
	public void render(Graphics g) {
		int diameter = size*4;
		g.setColor(col);
		g.fillOval(xPos-diameter/2, yPos-diameter/2, diameter, diameter);
	}
	
	public void setXPos(int xPos) {this.xPos=xPos;}
	public void setYPos(int yPos) {this.yPos=yPos;}
	public void setXVel(int xVel) {this.xVel=xVel;}
	public void setYVel(int yVel) {this.yVel=yVel;}
	public int getSize() {return size;}
	public int getXPos() {return xPos;}
	public int getYPos() {return yPos;}
	public int getXVel() {return xVel;}
	public int getYVel() {return yVel;}
}
