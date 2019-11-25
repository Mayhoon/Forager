package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MainClass;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = "LoveInPackages";
		config.width = 1920;
		config.height = 1080;
		config.fullscreen = true;
		config.forceExit = true;
		new LwjglApplication(new MainClass(), config);
	}
}