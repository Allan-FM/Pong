import java.awt.Color;
import java.awt.Graphics;

public class Enemy 
{
	public double x;
	public double y;
	
	public int width;
	public int heigth;
	
	public Enemy(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.width = 4;
		this.heigth = 2;
	}
	
	public void tick()
	{
		y += (Game.ball.y - y - 2);
	}
	public void render(Graphics g)
	{
		g.setColor(Color.white);
		g.fillRect((int)x,(int)y, 4, 30);
	}
}
