import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener
{

	private static final long serialVersionUID = 1L;
	private static int width = 240;
	private static int heigth = 140;
	private static int scale = 3;
	
	public static Player player;
	public static Enemy enemy;
	public static Ball ball;
	
	public BufferedImage layer = new BufferedImage(width, heigth, BufferedImage.TYPE_INT_RGB);
	
	public Game()
	{ 
		this.setPreferredSize(new Dimension(width * scale, heigth * scale));
		this.addKeyListener(this);
		player = new Player(0,50);
		enemy = new Enemy(236, 50);
		ball = new Ball(100, heigth / 2 - 1);
	}
	
	public static void main(String[] args)
	{
		Game game = new Game();
		JFrame frame =  new JFrame("Pong");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(game);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		new Thread(game).start();
	}
	public void tick()
	{
		player.tick();
		enemy.tick();
		ball.tick();
	}
	public void render()
	{
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = layer.getGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, width, heigth);
		player.render(g);
		enemy.render(g);
		ball.render(g);
		g = bs.getDrawGraphics();
		g.drawImage(layer, 0, 0,width * scale, heigth * scale, null);
		
		bs.show();
	}
	@Override
	public void run() 
	{
		while(true)
		{
			tick();
			render();
			try 
			{
				Thread.sleep(1000/60);
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			player.down = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			player.up = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			player.down = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			player.up = false;
		}
		
	}

}
