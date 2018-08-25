package main.states;

import java.awt.Graphics;
import main.Main;

public abstract class State {
    
    private static State currentState = null;
    private static State lastState = null;
    
    public static void setState(State state) {
        lastState = currentState;
    	currentState = state;
        currentState.reloadState();
    }

    public static State getState() {
        return currentState;
    }
    public static State getLastState() {
    	return lastState;
    }
    
    //Class
    protected Main main;

    public State(Main main) {
        this.main = main;
    }
    public abstract void update();
    public abstract void render(Graphics g);
    public abstract void reloadState();
}
