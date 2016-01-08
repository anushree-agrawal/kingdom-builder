import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.util.Scanner;
import java.util.ArrayList; 
import java.util.Collections; 

public class Card
{
	BufferedImage img;
	String fileName;
	String color; 
	public Card (String fname)
	{
		try{
		
		img = ImageIO.read(new File (fname));
		}
		catch (IOException e)
		{
			
		} 
		fileName = fname; 
		if (fileName.equals("dgreenCard.gif"))
			color = "darkgreen";
		else if (fileName.equals("flowerCard.gif"))
			color = "flower";
		else if (fileName.equals("lgreenCard.gif"))
			color = "lgreen";
		else if (fileName.equals("canyonCard.gif"))
			color = "brown";
		else if (fileName.equals("desertCard.gif"))
			color = "desert"; 
	}
	public String getFileName()
	{
		return fileName;
	}
	public BufferedImage getImage()
	{
		return img; 
	}
	public String getColor()
	{
		return color; 
	}
	
}