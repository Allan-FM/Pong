import java.awt.Color;
import java.awt.Graphics;

public class Player 
{
	public boolean up;
	public boolean down;
	
	public int x;
	public int y;
	
	public int width;
	public int heigth;
	
	public Player(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.width = 4;
		this.heigth = 2;
	}
	
	
	public void tick()
	{
		if(up)
		{
			y++;
		}
		else if(down)
		{
			y--;
		}
		if(y + heigth < Game.HEIGHT)
		{
			y = Game.HEIGHT - heigth;
		}
	}
	public void render(Graphics g)
	{
		g.setColor(Color.white);
		g.fillRect(x, y, 4,30);
	}
}
