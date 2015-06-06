package com.jos.shooot.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.jos.shooot.ShootGame;

public class DesktopLauncher {
  public static void main(String[] arg) {
    LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
    config.title = "Shoot";
    config.width = 600;
    config.height = 480;
    new LwjglApplication(new ShootGame(), config);
  }
}
