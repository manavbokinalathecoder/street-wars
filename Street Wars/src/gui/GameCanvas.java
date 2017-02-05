package gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import framework.Handler;
import framework.Side;
import framework.StickMan;

public class GameCanvas extends Canvas implements Runnable {

	boolean running = true;
	Thread thread;

	boolean init = false;

	static Handler handler = new Handler();

	PickBar p = new PickBar();
	
	public GameCanvas() {
		handler.addEntity(new StickMan(0, 0, 5, 0, Side.friend));
		handler.addEntity(new StickMan(600, 0, -5, 0, Side.foe));
		handler.addEntity(new StickMan(800, 0, -5, 0, Side.foe));
	}

	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
	}

	public void start() {
		thread = new Thread(this);
		thread.start();
	}

	public void tick() {
		if (!init) {
			init = true;
			init();
		}
		handler.tick();
		try {
			handler.collision();
			handler.removeAllDead();
		} catch (Exception e) {

		}
	}

	private void init() {

	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.BLACK);
		g2.fill(getBounds());

		handler.render(g);

		p.render(g);
		
		g.dispose();
		bs.show();
	}

}
