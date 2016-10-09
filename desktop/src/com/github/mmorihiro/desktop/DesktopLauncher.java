package com.github.mmorihiro.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.github.mmorihiro.core.LifeGame;

public class DesktopLauncher {
    
	public static void main (String[] arg) {
        LwjglApplicationConfiguration config =
                new LwjglApplicationConfiguration();
        config.foregroundFPS = 10;
        config.backgroundFPS = 10;
        new LwjglApplication(new LifeGame(), config);
    }
}
