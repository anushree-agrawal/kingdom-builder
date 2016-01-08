import java.awt.*;
import java.util.*; 
import java.io.*; 

public class Polygon2 extends Polygon
{
	boolean redHouse = false;
	boolean blueHouse = false; 
	String color = ""; 
	int middleX;
	int middleY; 
	public Polygon2(int x[], int y[], int z, String c)
	{
		super(x, y, z);
		color = c;
		middleX = (x[1]+x[4])/2;
		middleY = (y[0] + y[3])/2;
		
	}
	public void setHouse(House x)
	{
		if (x.getColor().equals("red"))
			redHouse = true;
		else if (x.getColor().equals("blue"))
			blueHouse = true; 
	}
	public boolean getRed()
	{
		return redHouse; 
	}
	public boolean getBlue()
	{
		return blueHouse; 
	}
	public String getColor()
	{
		return color; 
	}
	public int getMiddleX()
	{
		return middleX;
	}
	public int getMiddleY()
	{
		return middleY; 
	}
	public String toString()
	{
		return color; 
	}
	
	public ArrayList<Polygon2> getAdjacent(ArrayList<Polygon2> polygonList, int i)
    {
    	ArrayList<Polygon2> tempPolygonList = polygonList;
    	ArrayList<Polygon2> allTheAdjacents = new ArrayList<Polygon2>(); 
    	if (i %10 == 0&&i<200)
    	{
    		allTheAdjacents.add(polygonList.get(i+1)); 
    		if (i ==0)
    		{
    			allTheAdjacents.add(polygonList.get(i+10)); 
    		}
    		else if (i==190)
    		{
    			allTheAdjacents.add(polygonList.get(i-10));
    			allTheAdjacents.add(polygonList.get(i-9)); 
    		}
    		else
    		{
    			allTheAdjacents.add(polygonList.get(i+10));
    			allTheAdjacents.add(polygonList.get(i-10)); 
    		}
    		
    		if (i%20==10)
    		{
    			allTheAdjacents.add(polygonList.get(i+11));
    			allTheAdjacents.add(polygonList.get(i-9)); 
    		} 
    	} 
   		else if (i<9)
   		{
   			allTheAdjacents.add(polygonList.get(i+1));
   			allTheAdjacents.add(polygonList.get(i-1));
   			allTheAdjacents.add(polygonList.get(i+10));
   			allTheAdjacents.add(polygonList.get(i+9)); 
   		}
   		else if (i%10==9&&i<200)
   		{
   			allTheAdjacents.add(polygonList.get(i-1));
   			allTheAdjacents.add(polygonList.get(i+191));
   			if (i==9)
   			{
   				allTheAdjacents.add(polygonList.get(i+10));
   				allTheAdjacents.add(polygonList.get(i+9)); 
   			}
   			else if (i==199)
   			{
   				allTheAdjacents.add(polygonList.get(i-10));
   				allTheAdjacents.add(polygonList.get(i+181)); 
   			}
   			else if (i%20==19) 
   			{
   				allTheAdjacents.add(polygonList.get(i+181));
   				allTheAdjacents.add(polygonList.get(i-10)); 
   				allTheAdjacents.add(polygonList.get(i+10)); 
   				allTheAdjacents.add(polygonList.get(i+201)); 
   			}
   			else if (i%20==9)
   			{
   				allTheAdjacents.add(polygonList.get(i+10));
   				allTheAdjacents.add(polygonList.get(i-10));
   				allTheAdjacents.add(polygonList.get(i+9));
   				allTheAdjacents.add(polygonList.get(i-11));    
   			}
   		}
   		else if (i>190&&i<199)
   		{
   			allTheAdjacents.add(polygonList.get(i+1));
   			allTheAdjacents.add(polygonList.get(i-1));
   			allTheAdjacents.add(polygonList.get(i-10));
   			allTheAdjacents.add(polygonList.get(i-9)); 
   		}
   		else if (i>=200&&i%10==0)
   		{
   			allTheAdjacents.add(polygonList.get(i+1));
   			allTheAdjacents.add(polygonList.get(i-191));
   			if (i==200)
   			{
   				allTheAdjacents.add(polygonList.get(i+10));
   				allTheAdjacents.add(polygonList.get(i-181));
   			}
   			else if (i==390)
   			{
   				allTheAdjacents.add(polygonList.get(i-10));
   				allTheAdjacents.add(polygonList.get(i-9)); 
   			}
   			else if (i%20==10)
   			{
   				allTheAdjacents.add(polygonList.get(i-9));
   				allTheAdjacents.add(polygonList.get(i-10));	
   				allTheAdjacents.add(polygonList.get(i+10));
   				allTheAdjacents.add(polygonList.get(i+11));  
   			}
   			else if (i%20==0)
   			{
   				allTheAdjacents.add(polygonList.get(i-10));
   				allTheAdjacents.add(polygonList.get(i+10));
   				allTheAdjacents.add(polygonList.get(i-201));
   				allTheAdjacents.add(polygonList.get(i-181)); 
   			}
   		}
   		
   		else if (i>200&&i<210)
   		{
   			allTheAdjacents.add(polygonList.get(i-1));
   			if (i==209)
   			{
   				allTheAdjacents.add(polygonList.get(i+10));
   				allTheAdjacents.add(polygonList.get(i+9));
   			}
   			else
   			{
   				allTheAdjacents.add(polygonList.get(i+1));
   				allTheAdjacents.add(polygonList.get(i+10));
   				allTheAdjacents.add(polygonList.get(i+9)); 
   			}
   		
   		}
   		else if (i>209&&i%10==9&&i<400)
   		{
   			allTheAdjacents.add(polygonList.get(i-1));
   			if (i==399)
   			{
   				allTheAdjacents.add(polygonList.get(i-10));
   			}
   			else if (i/10%2==1)
   			{
   			allTheAdjacents.add(polygonList.get(i+10));
   			allTheAdjacents.add(polygonList.get(i-10));
   			 
   			}
   			else
   			{
   				allTheAdjacents.add(polygonList.get(i+10));
   				allTheAdjacents.add(polygonList.get(i-10)); 
   				allTheAdjacents.add(polygonList.get(i-11));
   				allTheAdjacents.add(polygonList.get(i+9)); 
   			}
   		}
   		else if (i>390&&i!=399)
   		{
   			allTheAdjacents.add(polygonList.get(i+1));
   			allTheAdjacents.add(polygonList.get(i-1));
   			allTheAdjacents.add(polygonList.get(i-10));
   			allTheAdjacents.add(polygonList.get(i-9)); 
   		}
   		else if (i/10%10%2==0)
   		{
   			allTheAdjacents.add(polygonList.get(i-1));
   			allTheAdjacents.add(polygonList.get(i+1));
   			allTheAdjacents.add(polygonList.get(i-10));
   			allTheAdjacents.add(polygonList.get(i-11));
   			allTheAdjacents.add(polygonList.get(i+9));
   			allTheAdjacents.add(polygonList.get(i+10)); 
   		}
   		else
   		{
   			allTheAdjacents.add(polygonList.get(i-1));
   			allTheAdjacents.add(polygonList.get(i+1));
   			allTheAdjacents.add(polygonList.get(i-10));
   			allTheAdjacents.add(polygonList.get(i-9));
   			allTheAdjacents.add(polygonList.get(i+11));
   			allTheAdjacents.add(polygonList.get(i+10)); 
   		}
   	
   		return allTheAdjacents; 
    }
   
	
}