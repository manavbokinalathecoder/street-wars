package framework;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class StickMan extends Entity {

	
	//0 = right
	//1 = left
	public int facing = 0;
	private int type;
	
	public StickMan(float x, float y, float velX, float velY, int type) {
		super(x, y, velX, velY);
		this.type = type;
		
		if(type == 2){
			health = 2;
		} else {
			health = 1;
		}
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
	}

	@Override
	public void render(Graphics g) {
		if(type == 2){
			g.setColor(Color.BLUE);
		} else {
			g.setColor(Color.RED);
		}
		g.fillRect((int)x, (int)y, 32, 64);
	}
	
	public int getType(){
		return type;
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 32, 64);
	}

	@Override
	public String toString() {
		return "StickMan [facing=" + facing + ", type=" + type + ", x=" + x + ", y=" + y + ", velX=" + velX + ", velY="
				+ velY + ", gravity=" + gravity + ", falling=" + falling + ", health=" + health + "]";
	}

}
