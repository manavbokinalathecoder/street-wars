package framework;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class Handler {

	private ArrayList<Entity> entities;
	
	public static final Point PLAYER_SPAWN_POINT = new Point(0, 500);
	public static final Point ENEMY_SPAWN_POINT = new Point(700, 500);
	
	
	
	public Handler(){
		entities = new ArrayList<Entity>();
	}
	
	public void addEntity(Entity e){
		entities.add(e);
	}
	
	public void removeEntity(Entity e){
		entities.remove(e);
	}
	
	public ArrayList<Entity> getAllEntities(){
		return entities;
	}
	
	public void tick(){
		for(Entity e : entities){
			e.tick();
		}
	}
	
	public void render(Graphics g){
		for(Entity e : entities){
			e.render(g);
		}
	}
	
	public void collision() throws Exception{
		for(Entity e : entities){
			for(Entity i : entities){
				if(!(i.equals(e))){
					if(e.getBounds().intersects(i.getBounds())){
						removeHealth(i);
						removeHealth(e);
					}
				}
			}
		}
	}
	
	public void removeHealth(Entity e){
		e.health--;
	}
	
	public void removeAllDead(){
		for(Entity e : entities){
			if(e.health <= 0){
				entities.remove(e);
			}
		}
	}
	
}
