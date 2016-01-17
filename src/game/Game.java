package game;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

/*
 * Space Game OpenGL branch using lwjgl 2.x and Opengl 3.2 libraries
 * Author: John Thornton, Ryan St. John
 * 1/17/16
 */

public class Game{
	
	//start the game state
	public void start(){
		createDisplay();
		
		while(!Display.isCloseRequested()){
			
			GL11.glClearColor(0, 0, 0, 0);
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
            GL11.glEnable(GL11.GL_DEPTH_TEST);
			
            
            
			Display.update();
		}
	}
	
	//Pause the game state
	public void pause(){
		
	}
	
	//Exit the game
	public void stop(){
		Display.destroy();
		System.out.println("Exited Space Game, thanks for playing!");
	}
	
	private void createDisplay(){
		try {
			if(!Display.isCreated()){
				Display.setDisplayMode(new DisplayMode(Settings.windowWidth, Settings.windowHeight));
				Display.setTitle("Space Game");
				Display.create();
			}else{
				System.err.println("You already have an instance of the game running!");
			}
		} catch (LWJGLException exception) {
			System.err.println("Error while creating the window display.");
			if(Settings.enableInternalErrors){
				exception.printStackTrace();
			}
		}
	}
	
}