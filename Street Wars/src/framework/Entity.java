package framework;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {

	public float x, y;
	public float velX, velY;
	
	public float gravity;
	
	public boolean falling = false;
	
	int health;
	
	public Entity(float x, float y, float velX, float velY){
		this.x = x;
		this.y = y;
		this.velX = velX;
		this.velY = velY;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 32, 64);
	}
	
}
