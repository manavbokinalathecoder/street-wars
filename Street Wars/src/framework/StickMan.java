package framework;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class StickMan extends Entity {

	
	//0 = right
	//1 = left
	public int facing = 0;
	private Side side;
	
	public StickMan(float x, float y, float velX, float velY, Side side) {
		super(x, y, velX, velY);
		this.side = side;
		
		//type 2 = friend
		//type 1 = foe
		
		if(side == Side.friend){
			health = 2;
			System.out.println("FRIEND CREATED");
		} else if(side == Side.foe){
			health = 1;
			System.out.println("FOE CREATED");
		}
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		System.out.println("health: " + health + " side: " + side);
	}

	@Override
	public void render(Graphics g) {
		if(side == Side.friend){
			g.setColor(Color.BLUE);
		} else if(side == Side.foe){
			g.setColor(Color.RED);
		}
		g.fillRect((int)x, (int)y, 32, 64);
	}
	
	public Side getSide(){
		return side;
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 32, 64);
	}

	@Override
	public String toString() {
		return "StickMan [facing=" + facing + ", side=" + side + ", x=" + x + ", y=" + y + ", velX=" + velX + ", velY="
				+ velY + ", gravity=" + gravity + ", falling=" + falling + ", health=" + health + "]";
	}

}
