package shader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

import game.Game;
import game.Settings;

public class Shader3D {
	
	Game game;
	
	public Shader3D(Game game){
		this.game = game;
	}

	@SuppressWarnings("unused")
	private int loadShader(String file, int type){
        StringBuilder shaderSource = new StringBuilder();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while((line = reader.readLine()) != null){
                shaderSource.append(line).append("\n");
            }
            reader.close();
        }catch(IOException exception){
           System.err.println("Error while loading the shader file.");
           if(Settings.enableInternalErrors){
        	   exception.printStackTrace();
           }
           game.stop();
        }
        
        int shaderID = GL20.glCreateShader(type);
        GL20.glShaderSource(shaderID, shaderSource);
        GL20.glCompileShader(shaderID);
        if(GL20.glGetShaderi(shaderID, GL20.GL_COMPILE_STATUS)==GL11.GL_FALSE){
        	System.err.println("could not compile shader.");
        	if(Settings.enableInternalErrors){
        		System.out.println(GL20.glGetShaderInfoLog(shaderID, 500));
        	}
            game.stop();
        }
        return shaderID;
           
    }
}
