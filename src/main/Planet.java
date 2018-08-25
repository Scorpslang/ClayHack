package main;

import java.awt.Color;
import java.awt.Graphics;

public class Planet {
	private int xPos;
	private int yPos;
	private Color col;
	private int size; 		//1-10
	
	public Planet(int xPos, int yPos, Color col, int size) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.col = col;
		this.size = size;
	}
	
	public void render(Graphics g){
		int diameter = size*20;
		g.setColor(col);
		g.fillOval(xPos-diameter/2, yPos-diameter/2, diameter, diameter);
	}
	
	public int getXPos() {return xPos;}
	public int getYPos() {return yPos;}
	public int getSize() {return size;}
	public Color getCol() {return col;}
}
