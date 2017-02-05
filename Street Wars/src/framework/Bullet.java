package framework;

import java.awt.Graphics;

public class Bullet extends Entity {

	public Bullet(float x, float y) {
		super(x, y, 5, 0);
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
	}

	@Override
	public void render(Graphics g) {

	}

}
