public class House
{
	private int x;
	private int y;
	private String color;
	public House(int theX, int theY, String theCol)
	{
		x = theX;
		y = theY;
		color = theCol; 
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public String getColor()
	{
		return color; 
	}
}