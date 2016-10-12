package com.github.mmorihiro.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.github.mmorihiro.core.LifeGame;

public class DesktopLauncher {
    
	public static void main (String[] arg) {
        LwjglApplicationConfiguration config =
                new LwjglApplicationConfiguration();
        config.width = 300;
        config.height = 350;
        config.foregroundFPS = 10;
        config.backgroundFPS = 10;
        config.resizable = false;
        new LwjglApplication(new LifeGame(), config);
    }
}
