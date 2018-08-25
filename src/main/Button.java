package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class Button {
    
    private Color button;
    private Color highlightButton;
    private Color txt;
    private int x,y;
    private int width, height;
    private String text;
    private String shape;
    
    private boolean highlighted=false;
    
    private boolean clickable=true;
    private BufferedImage inactiveTexture;
    
    public Button(Color button, Color highlightButton, Color txt, int x, int y, int width, int height, String text, String shape){
        this.button = button;
        this.highlightButton = highlightButton;
        this.txt = txt;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
        this.shape = shape;
        clickable=true;
    }
    
    //Special button types
    public Button(Color button, Color highlightButton, Color txt, String type){
    	this.button = button;
        this.highlightButton = highlightButton;
        this.txt = txt;
        if(type.equalsIgnoreCase("BACK")){
        	x = 16;
        	y = 16;
        	//testing comment
        	width = 32;
        	height = 32;
        	text = "";
        	shape = "BACK";
        }
        clickable = true;
    }
    
    public void update(int mousex, int mousey){
        if(mousex > x && mousex < x + width){
            if(mousey > y && mousey < y + height){
                highlighted = true;
            } else {
                highlighted = false;
            }
        } else {
            highlighted = false;
        }
    }
    
    public void render(Graphics g){
        if(highlighted){
            g.setColor(highlightButton);
        } else {
            g.setColor(button);
        }
        if(shape.equalsIgnoreCase("RECT"))
            g.fillRect(x, y, width, height);
        else if(shape.equalsIgnoreCase("OVAL"))
            g.fillOval(x, y, width, height);
        else if(shape.equalsIgnoreCase("BACK")){
        	g.fillRect(x, y, width, height);
        	g.setColor(txt);
        	g.fillPolygon(new int[] {x+width/4, x+width*3/4, x+width*3/4}, new int[] {y+height/2, y+height/6, y+height*5/6}, 3);
        }
    }
    
    public void centerLabel(Graphics g) {
    	g.setColor(txt);
        g.drawString(text, x + width/2 - (g.getFontMetrics().stringWidth(text) / 2), y + height/2 - (g.getFontMetrics().getHeight()/2)+ g.getFontMetrics().getAscent());
    }
    
    public boolean click(boolean leftpress){
        if(clickable==false){
            return false;
        }
        if(highlighted){
            if(leftpress){
            	try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					System.err.println("Button not delayed");
				}
                return true;
            }
        }
        return false;
    }
    
    //getters & setters
    public String getText(){return text;}
    public int getY(){return y;}
    
    public void setClickable(boolean clickable){this.clickable = clickable;}
    public void setText(String newText){}
}
