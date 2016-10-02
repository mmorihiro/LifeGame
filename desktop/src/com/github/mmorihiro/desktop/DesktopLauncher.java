package com.github.mmorihiro.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import main.core.LifeGame;

public class DesktopLauncher {
    
	public static void main (String[] arg) {
        LwjglApplicationConfiguration config =
                new LwjglApplicationConfiguration();
        new LwjglApplication(new LifeGame(), config);
    }
}
