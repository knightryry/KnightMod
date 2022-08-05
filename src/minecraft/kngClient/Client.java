package kngClient;

import org.lwjgl.opengl.Display;

import kngClient.event.EventManager;

public class Client {
	
	public String name = "KNGClient", version = "Dev 1.0.0 (CLOSED DEV)";
	public static Client INSTANCE = new Client();
	
	public EventManager eventManager;
	
	public void startup() {
		
		eventManager = new EventManager();
		
		
		
		
		Display.setTitle(name + " | " + version);
		EventManager.register(this);
		
	}
	
	public void shutdown() {
		
		EventManager.unregister(this);
		
	}
	

}
