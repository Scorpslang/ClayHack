package main.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;

import main.Button;
import main.Main;
import static main.Main.height;
import static main.Main.width;
import main.Player;
import main.Driver;

public class MenuState extends State{
    
    private Button newGameButton;
    private Button exitButton;
    private Player player;
    
    public MenuState(Main main){
        super(main);
        
        newGameButton = new Button(new Color(182, 161, 251), new Color(182, 161, 251).brighter(), new Color(85, 73, 123), Main.width / 3, Main.height / 3, 200, 50, "New Game", "RECT");
        exitButton = new Button(new Color(254, 151, 167), new Color(254, 151, 167).brighter(), new Color(161, 76, 89), Main.width / 3, Main.height / 2, 200, 50, "Exit", "RECT");
        player = main.getPlayer();
        
        //Color button, Color highlightButton, Color txt, int x, int y, int width, int height, String text, String shape
        
    }

    @Override
    public void update(){
        
        newGameButton.update((int)player.getMouseX(), (int)player.getMouseY());
        exitButton.update((int)player.getMouseX(), (int)player.getMouseY());
        
        if(newGameButton.click(player.getLeftPressed())){
            System.out.print("thing1");
        	State.setState(main.getGameState());
        }
        
        if(exitButton.click(player.getLeftPressed())){
        	System.out.println("thing2");
            System.exit(0);
        }
    }
    
    @Override
    public void render(Graphics g){
        
        String message;
        if(Driver.status.equalsIgnoreCase("START"))
        	message = "Welcome to Interplanetary Pong";
        else if(Driver.status.equalsIgnoreCase("LEFTWIN"))
        	message = "Left Player Wins!";
        else if(Driver.status.equalsIgnoreCase("RIGHTWIN"))
        	message = "Right Player Wins!";
        else
        	message = "How'd you manage that?";
        
        g.setFont(new Font("Impact", Font.BOLD, 50));
        g.setColor(new Color(28, 109, 144));
        g.drawString(message, (width / 2) - (g.getFontMetrics().stringWidth(message)/2), (height / 2) - 60);
        
        g.setFont(new Font("Impact", Font.BOLD, 35));
        newGameButton.render(g);
        newGameButton.centerLabel(g);
        
        g.setFont(new Font("Impact", Font.BOLD, 35));
        exitButton.render(g);
        exitButton.centerLabel(g);
    }
    
    @Override
    public void reloadState(){
        
    }

}
