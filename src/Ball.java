import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ball 
{
	public int x;
	public int y;
	
	public int width;
	public int heigth;
	
	public double dirX;
	public double dirY;
	public double speed = 2.5;
	
	public Ball(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.width = 4;
		this.heigth = 4;
		
		dirX = new Random().nextGaussian();
		dirY = new Random().nextGaussian();
	}
	public void tick()
	{
		x += dirX * speed;
		y += dirY * speed;
		
	}
	public void render(Graphics g)
	{
		g.setColor(Color.white);
		g.fillRect(x, y, width, heigth);
	}
}
