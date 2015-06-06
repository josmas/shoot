package com.jos.shooot;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ShootGame extends ApplicationAdapter {
  private Texture dude;
  private OrthographicCamera camera;
  private SpriteBatch batch;
  private Sprite dudeSprite;

  @Override
  public void create() {

    camera = new OrthographicCamera();
    camera.setToOrtho(false, 600, 480);

    dude = new Texture("dude_gun_sprite.png");
    dudeSprite = new Sprite(dude, 0, 0, 40, 48);
    batch = new SpriteBatch();

  }

  float dudeSpeed = 10.0f;
  float dudeX;
  float dudeY;
  boolean flip = false;

  @Override
  public void render() {
    Gdx.gl.glClearColor(1, 1, 0, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    if (Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT)) {
      dudeX -= Gdx.graphics.getDeltaTime() * dudeSpeed * 10;
      if (flip) {
        dudeSprite.flip(flip, false);
        flip = false;
      }
    }
    if (Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT)) {
      dudeX += Gdx.graphics.getDeltaTime() * dudeSpeed * 10;
      if (!flip) {
        dudeSprite.flip(true, false);
        flip = true;
      }
    }

    if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
      dudeY += Gdx.graphics.getDeltaTime() * dudeSpeed * 10;
    }

    batch.begin();
    batch.draw(dudeSprite, dudeX, dudeY);
    batch.end();

  }

  @Override
  public void dispose() {
    //TODO (jos) What else do we need to dispose of?
    batch.dispose();
    dude.dispose();
  }
}
