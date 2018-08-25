package main;

import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.KeyEvent;


public class Player implements MouseListener, MouseMotionListener, KeyListener{
    
    private double x,y;
    private double radius=10;
    private boolean leftPressed;
    private boolean rightPressed;
    private boolean leftDragged;
    private boolean lArrowPressed;
    private boolean rArrowPressed;
    private boolean aPressed;
    private boolean dPressed;
    
    public Player(){
        x = Main.width/2;
        y = Main.height/2;
    }
    
    @Override
    public void mouseDragged(MouseEvent me) {
        x = me.getX()- radius / 2;
        y = me.getY()- radius / 2;
        if(me.getButton() == MouseEvent.BUTTON1){
            leftDragged = true;
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        x = me.getX()- radius / 2;
        y = me.getY()- radius / 2;
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if(me.getButton() == MouseEvent.BUTTON1){
            leftPressed = true;
        }else if(me.getButton() == MouseEvent.BUTTON2) {
            rightPressed = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if(me.getButton() == MouseEvent.BUTTON1){
            leftPressed = false;
        }else if(me.getButton() == MouseEvent.BUTTON2) {
            rightPressed = false;
        }
    }
    
    public void keyTyped(KeyEvent e) {
    	
    }
    
    public void keyPressed(KeyEvent e) {
    	if(e.getKeyCode()==KeyEvent.VK_LEFT)
    		lArrowPressed = true;
    	else if(e.getKeyCode()==KeyEvent.VK_RIGHT)
    		rArrowPressed = true;
    	else if(e.getKeyCode()==KeyEvent.VK_A)
    		aPressed = true;
    	else if(e.getKeyCode()==KeyEvent.VK_D)
    	    dPressed = true;
    }
    
    public void keyReleased(KeyEvent e) {
    	if(e.getKeyCode()==KeyEvent.VK_LEFT)
    		lArrowPressed = false;
    	else if(e.getKeyCode()==KeyEvent.VK_RIGHT)
    		rArrowPressed = false;
    	else if(e.getKeyCode()==KeyEvent.VK_A)
    		aPressed = false;
    	else if(e.getKeyCode()==KeyEvent.VK_D)
            dPressed = false;
    }
    
    //Getters
    public double getMouseX(){return x + radius/2;}
    public double getMouseY(){return y + radius/2;}
    public boolean getLeftPressed(){return leftPressed;}
    public boolean getRightPressed(){return rightPressed;}
    public boolean getLeftDragged(){return leftDragged;}
    public boolean getLArrowPressed(){return lArrowPressed;}
    public boolean getRArrowPressed(){return rArrowPressed;}
    public boolean getAPressed() {return aPressed;}
    public boolean getDPressed() {return dPressed;}
    
    
    @Override
    public void mouseClicked(MouseEvent me) {}
    public void mouseEntered(MouseEvent me) {}
    public void mouseExited(MouseEvent me) {}
}
