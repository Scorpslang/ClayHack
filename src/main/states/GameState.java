package main.states;

import java.awt.Color;
import java.awt.Graphics;

import main.Main;
import main.Planet;
import main.Player;
import main.Ball;
import main.Blocker;
import main.Driver;

import static main.Main.height;
import static main.Main.width;

public class GameState extends State {
	
	private Ball ball;
	private Planet leftPlanet,rightPlanet;
	private Blocker leftBlocker,rightBlocker;
	private Player player;
	
	public GameState(Main main) {
		super(main);
		ball = new Ball(Main.width/2 + 20,Main.height/2 + 20,0,0,new Color(178, 62, 62),5);
		leftPlanet = new Planet(Main.width/4,Main.height/2,new Color(28, 112, 56), 5);
		rightPlanet = new Planet(Main.width*3/4,Main.height/2,new Color(28, 83, 112), 5);
		leftBlocker = new Blocker(leftPlanet, 0);
		rightBlocker = new Blocker(rightPlanet,180);
		player = main.getPlayer();
	}

	@Override
	public void update() {
		if(player.getAPressed()) {
			leftBlocker.setAngle(leftBlocker.getAngle()+5);
		}
		if(player.getDPressed()) {
			leftBlocker.setAngle(leftBlocker.getAngle()-5);
		}
		if(player.getLArrowPressed()) {
			leftBlocker.setAngle(leftBlocker.getAngle()+5);
		}
		if(player.getRArrowPressed()) {
			leftBlocker.setAngle(leftBlocker.getAngle()-5);
		}
		
		ball.setXPos(ball.getXPos()+ball.getXVel());
		ball.setYPos(ball.getYPos()+ball.getYVel());
		double grav = 2;
		int leftAccelAtBall = (int)(grav*ball.getSize()*leftPlanet.getSize()/(Math.pow(ball.getXPos()-leftPlanet.getXPos(), 2)+Math.pow(ball.getYPos()-leftPlanet.getYPos(), 2)));
		int rightAccelAtBall = (int)(grav*ball.getSize()*rightPlanet.getSize()/(Math.pow(ball.getXPos()-rightPlanet.getXPos(), 2)+Math.pow(ball.getYPos()-rightPlanet.getYPos(), 2)));
		int xAcc = (int)(leftAccelAtBall*Math.cos(leftPlanet.getXPos()-ball.getXPos())) + (int)(rightAccelAtBall*Math.cos(rightPlanet.getXPos()-ball.getXPos()));
		int yAcc = (int)(leftAccelAtBall*Math.sin(leftPlanet.getYPos()-ball.getYPos())) + (int)(rightAccelAtBall*Math.sin(rightPlanet.getYPos()-ball.getYPos()));
		ball.setXVel(ball.getXVel()+xAcc);
		ball.setYVel(ball.getYVel()+yAcc);
		int dist = (int) Math.sqrt(Math.pow(ball.getXPos()-leftPlanet.getXPos(), 2)+Math.pow(ball.getYPos()-leftPlanet.getYPos(), 2));
		if((leftPlanet.getSize()*12)+(ball.getSize()*2)<=dist) {
			if((leftPlanet.getSize()*10)+(ball.getSize()*2)<=dist) {
				Driver.status = "RIGHTWIN";
			}else {
				int angle = (int) Math.atan(Math.cos(leftPlanet.getYPos()-ball.getYPos())/Math.cos(leftPlanet.getXPos()-ball.getXPos()));
				if(angle>=leftBlocker.getAngle() && angle<=leftBlocker.getAngle()+leftBlocker.getSize()) {
					//deflect
				}
			}
		}
		if((rightPlanet.getSize()*12)+(ball.getSize()*2)<=dist) {
			if((rightPlanet.getSize()*10)+(ball.getSize()*2)<=dist) {
				Driver.status = "LEFTWIN";
			}else {
				int angle = (int) Math.atan(Math.cos(rightPlanet.getYPos()-ball.getYPos())/Math.cos(rightPlanet.getXPos()-ball.getXPos()));
				if(angle>=rightBlocker.getAngle() && angle<=rightBlocker.getAngle()+rightBlocker.getSize()) {
					//deflect
				}
			}
		}
	}

	@Override
	public void render(Graphics g) {
		leftBlocker.render(g);
		rightBlocker.render(g);
		leftPlanet.render(g);
		rightPlanet.render(g);
		ball.render(g);
	}

	@Override
	public void reloadState() {
		ball = new Ball(Main.width/2,Main.height/2,0,0,new Color(178, 62, 62),5);
		leftPlanet = new Planet(Main.width/4,Main.height/2,new Color(28, 112, 56), 5);
		rightPlanet = new Planet(Main.width/4,Main.height/2,new Color(28, 83, 112), 5);
		leftBlocker = new Blocker(leftPlanet, 0);
		rightBlocker = new Blocker(rightPlanet,180);
	}

}
