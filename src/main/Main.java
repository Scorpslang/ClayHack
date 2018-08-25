package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import main.states.*;

public class Main extends Loop{
    
    private Display display;
    private BufferStrategy bs;
    private Graphics g;
    public static int width, height;
    
    public static final String VERSION = "V. Alpha 0.1";
    
    private double score=0;
    private double maxScore=0;
    
    private State menuState;
    private State gameState;
    
    private String status;
    private Player player;
    
    @Override
    public void startup() {
        width = 1080;
        height = 720;
        
        display = new Display("Planetary Protection", width, height);
        status = Driver.status;
        
        player = new Player();
        
        menuState = new MenuState(this);
        gameState = new GameState(this);
        
        State.setState(menuState);
        
        display.getFrame().addMouseMotionListener(player);
        display.getFrame().addMouseListener(player);
        display.getCanvas().addMouseMotionListener(player);
        display.getCanvas().addMouseListener(player);
    }
    
    @Override
    public void shutdown() {
        
    }

    @Override
    public void update() {
        State.getState().update();
    }
    
    @Override
    public void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0, 0, width, height);
        
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, width, height);
        
        State.getState().render(g);
        
        bs.show();
        g.dispose();
    }
    
    
    //Setters and Getters
    public double getScore(){return score;}
    public void setScore(double score){this.score = score;}
    public double getMaxScore(){return maxScore;}
    public void setMaxScore(double score){this.maxScore = score;}
    
    public Player getPlayer(){return player;}
    public String getStatus(){return status;}
    
    public State getMenuState(){return menuState;}
    public State getGameState(){return gameState;}
}
