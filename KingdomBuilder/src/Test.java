public class Test
{
	public static void main (String args [])
	{
		String x = "absdfsfg";
		for (int i = 0; i< x.length(); i++)
		{
			char b = x.charAt(i);
			int y = (int)b; 
			
			y++;
			b = (char)y;
			System.out.println(b); 
			
		}
	}
}
