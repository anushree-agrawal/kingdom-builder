import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.util.Scanner;
import java.util.ArrayList; 
import java.util.Collections; 

public class LoadImageApp extends Component implements MouseListener{
          
    BufferedImage green, forest, flower, city, canyon, desert, stone, water, redHouse, blueHouse, gameOver;
    Card deckAt; 
    Card dgreenCard, flowerCard, lgreenCard, canyonCard, desertCard;
    BufferedImage farmers, citizens, lords, hermits, knights, discoverers, workers, merchants, miners, fisherman; 
 	int redScore =0;
 	int blueScore = 0;
    ArrayList <String[][]> lists; 
 	int num1, num2; 
	
	ArrayList<House>redHouses = new ArrayList<House>();
	ArrayList<House>blueHouses = new ArrayList<House>(); 
	ArrayList<Integer>listOfInts = new ArrayList<Integer>();  
 	ArrayList <House> listOfRect = new ArrayList<House>();
    ArrayList<Polygon2> polygonList = new ArrayList<Polygon2>(); 
    ArrayList<Card> deck = new ArrayList<Card>(); 
  	int theNum = 1; 
  	BufferedImage kik;
  	BufferedImage kik2, kik3; 
  	ArrayList <BufferedImage> deckOfPeople = new ArrayList<BufferedImage>(); 

	public void setDeck()
	{
		 for (int i = 0; i<5; i++)
      {
      	deck.add(dgreenCard);
      	deck.add(flowerCard);
      	deck.add(lgreenCard);
      	deck.add(canyonCard);
      	deck.add(desertCard); 
      }
	}
    public void paint(Graphics g){
    
    	System.out.println("true"); 
    	g.drawRect(1210, 195, 415, 230);
    	g.drawRect(1297, 445, 137, 222 );
    	g.drawRect(1308, 698, 112, 92);
    	g.setColor(Color.WHITE); 
    	g.fillRect(1310, 700, 110, 90);
    	String [][] list1; 
    	int x = 0;
    	int y = 0;
    	boolean six = false;
    	
    	g.drawImage(kik, 1220, 200, null);
    	g.drawImage(kik2, 1350, 200, null); 
    	g.drawImage(kik3, 1480, 200, null); 
    	for (int s = 0; s<4; s++){
    	list1 = lists.get(s); 
    	boolean test = false;
    
    	if (s==2)
    	{
 			if (six==false)
 			{
    		x=552;
    		y=0; 
    		six=true; 
 			}
 		}
    	
    	for (int i = 0; i<10; i++)
    	{
    		if (test== false)
    		{
    			test = true;
    		}
    		else
    		{
    			test = false; 
    			x += 27;
    		}
    		for (int b = 0; b<10; b++)
    		{
    			if (list1[i][b].equals("g"))
    			{
    				g.drawImage(green, x, y, null); 
    			}
    			if (list1[i][b].equals("dg"))
    				g.drawImage(forest, x, y, null); 
    			if (list1[i][b].equals("b"))
    				g.drawImage(water, x, y, null); 
    			if (list1[i][b].equals("c"))
    				g.drawImage(city, x, y, null);
    			if (list1[i][b].equals("br"))
    				g.drawImage(canyon, x, y, null);
    			if (list1[i][b].equals("bl"))
    				g.drawImage(stone, x, y, null);	
    			if (list1[i][b].equals("y"))
    				g.drawImage(desert, x, y, null);
    			if (list1[i][b].equals("o"))
    				g.drawImage(flower, x, y, null);
    			int [] theX = {x+27, x, x, x+27, x+55, x+55};  
    			int [] theY = {y, y+15, y+45, y+60, y+45, y+15}; 
    			g.setColor(Color.BLACK);
    			g.drawPolygon(theX, theY, 6); 
    			x+=55;
    		
    		 
    		}
    		if (s==0||s==1)
    		x=0; 
    		else
    			x=554; 
    			y+=44;  
    	}
    		if (s==0||s==2)
    		y+=4;
    	}
    	
    	
    		
    		boolean tempCard = false; 
    		boolean crap = false; 
    		ArrayList<Polygon2> adjacents2 = new ArrayList<Polygon2>(); 
			if (blueHouses.size()>=40||redHouses.size()>=40)
      		{
      			g.setFont(new Font ("Impact", Font.PLAIN, 100));
      			g.drawString("GAME OVER", 100, 100);
      			fisherman();
      			System.out.println(redScore);
      			System.out.println(blueScore); 
      		}	
    		for (int i = 0; i<polygonList.size(); i++)
      		{
      			adjacents2 = polygonList.get(i).getAdjacent(polygonList, i);
	
      		if (polygonList.get(i).contains(num1, num2)&&polygonList.get(i).getColor().equals(deckAt.getColor())&&redHouses.size()<40&&blueHouses.size()<40)
      		{
      			
      			System.out.println(polygonList.get(i) + " " + adjacents2 + " " + i);  
      			System.out.println(i); 
      			if (polygonList.get(i).getColor().equals("blue")||polygonList.get(i).getColor().equals("black"))
      			{
      				g.drawImage(deckAt.getImage(), 1300, 450, null); 
      				tempCard= true; 
      				
      				g.drawString("She Doesn't Even", 1320, 750);
      				g.drawString(" Go There", 1335, 761);
      			}
      			
      			
      			else if (polygonList.get(i).getBlue()==false&&polygonList.get(i).getRed()==false)
      			{
      				
      				for (int f = 0; f<adjacents2.size(); f++)
      				{
      					if (theNum<4){
      					
      					if (adjacents2.get(f).getRed()==true&&crap==false||listOfRect.isEmpty()&&crap==false||redHouses.isEmpty()==true&&crap==false&&theNum<4||moreRedAdjacents(deckAt.getColor())==false&&crap==false)
      					{
	      					if (theNum==1||theNum==2||theNum==3)
	      					{
	      						if (theNum==1)
	      						{
	      							g.drawString("2 Houses Left", 1322, 750); 
	      						}
	      						else if (theNum==2)
	      							g.drawString("1 House Left", 1322, 750);  
	      						else if (theNum==3)
	      							g.drawString("Player 2's Turn", 1322, 750);  		
		      					House brect = new House ((polygonList.get(i).getMiddleX())-8, (polygonList.get(i).getMiddleY())-8, "red");
		      					Polygon2 thePoly = polygonList.get(i);
		      					thePoly.setHouse(brect); 
		      					polygonList.set(i, thePoly); 
		      					listOfRect.add(brect);
		      					redHouses.add(brect); 
		      					tempCard = true; 
		      					g.drawImage(deckAt.getImage(), 1300, 450, null); 
		      					crap=true; 	
		      					theNum++; 
	      					}
	      			
      					}

      				}
      				
      				}
      				
		      		
		      			for (int z = 0; z<adjacents2.size(); z++){
		      			if (theNum>3){
		      			
		      			if (adjacents2.get(z).getBlue()==true&&crap==false||listOfRect.isEmpty()&&crap==false||blueHouses.isEmpty()&&crap==false||moreBlueAdjacents(deckAt.getColor())==false&&crap==false)
		      			{
		      				if (theNum==4)
		      					g.drawString("2 Houses Left", 1322, 750); 
		      				if (theNum==5)
	      						g.drawString("1 House Left", 1322, 750);  
	      					if (theNum==6)
	      						g.drawString("Player 1's Turn", 1322, 750);  
		      				House brect = new House ((polygonList.get(i).getMiddleX())-8, (polygonList.get(i).getMiddleY())-8, "blue"); 
		      				Polygon2 thePoly = polygonList.get(i);
		      				thePoly.setHouse(brect); 
		      				polygonList.set(i, thePoly); 
		      				blueHouses.add(brect); 
		      				listOfRect.add(brect);
		      				tempCard = true; 
		      				g.drawImage(deckAt.getImage(), 1300, 450, null); 
		      				theNum++;
		      				crap=true;  
		      			}

		      			tempCard = true; 
		      			g.drawImage(deckAt.getImage(), 1300, 450, null); 	
		      			}		 
		      		}
      			}
	      		
      		
      			
      		else
      		{
      			g.drawImage(deckAt.getImage(), 1300, 450, null);
      			tempCard = true; 
      			g.drawString("She Doesn't Even", 1320, 750);
      			g.drawString(" Go There", 1335, 765);
      		}

      		
      		
      		}
      		
      		else if (polygonList.get(i).contains(num1, num2))
      		{
      			g.drawImage(deckAt.getImage(), 1300, 450, null);
      			tempCard = true;
      			 
      			g.drawString("She Doesn't Even", 1320, 750);
      			g.drawString(" Go There", 1335, 761);
      		}
      		
      	}
      		
      		
      		if (tempCard == false)
      		{
      			if (deck.isEmpty())
      			{
      				setDeck(); 	
      			}
      			else {
      			
      			deckAt = deck.remove(0); 
      			}
      			g.drawImage(deckAt.getImage(), 1300, 450, null);
      			
      			
      		}
    
      		
      		 
      		if (theNum==7)
      			theNum=1; 
      		
      		for (int c = 0; c<listOfRect.size(); c++)
      		{
      			int num10 = listOfRect.get(c).getX(); 
      			int num20 = listOfRect.get(c).getY();
      			if (listOfRect.get(c).getColor().equals("red"))
      			g.drawImage(redHouse, num10, num20, null); 
      				
      			else if (listOfRect.get(c).getColor().equals("blue"))
      			g.drawImage(blueHouse, num10, num20, null);
      		}
      		Collections.shuffle(deck); 
      			
      			//System.out.println(polygonList.get(370).getAdjacent(polygonList, 370));
      	 
      	
      	
    }

    public LoadImageApp(String [][] temp, String [][] temp2, String [][] temp3, String [][] temp4) {
    	
       try {
       	   fisherman = ImageIO.read(new File ("fisherman.gif"));
       	   farmers = ImageIO.read(new File("farmers.gif"));
           citizens = ImageIO.read(new File ("citizens.gif"));
           lords = ImageIO.read(new File ("lords.gif"));
           hermits = ImageIO.read(new File ("hermits.gif"));
           knights = ImageIO.read(new File ("knights.gif"));
           discoverers = ImageIO.read(new File ("discoverers.gif"));
           workers = ImageIO.read(new File ("workers.gif"));
           merchants = ImageIO.read(new File ("merchants.gif"));
           miners = ImageIO.read(new File ("miners.gif"));
           green = ImageIO.read(new File("Hexagon Green2.gif"));
           forest = ImageIO.read(new File ("Hexagon Dark Green2.gif"));
           flower = ImageIO.read(new File ("Hexagon Flower2.gif"));
           city = ImageIO.read(new File ("Hexagon City2.gif")); 
           canyon = ImageIO.read(new File ("Hexagon Dark Brown2.gif"));
           desert = ImageIO.read(new File ("Hexagon Sand2.gif"));
           stone = ImageIO.read(new File ("Hexagon Stone2.gif"));
           water = ImageIO.read(new File ("Hexagon Water2.gif"));
           redHouse = ImageIO.read(new File ("RedHouse.gif")); 
           blueHouse = ImageIO.read(new File ("BlueHouse.gif"));
           dgreenCard = new Card ("dgreenCard.gif"); 
           flowerCard = new Card("flowerCard.gif");
           lgreenCard = new Card ("lgreenCard.gif");
           canyonCard = new Card("canyonCard.gif");
           desertCard = new Card ("desertCard.gif");  
           farmers = ImageIO.read(new File("farmers.gif"));
       } catch (IOException e) {
       }
      lists = new ArrayList<String [][]>(); 
      lists.add(temp); 
      lists.add(temp2);
      lists.add(temp3);
      lists.add(temp4); 
      theNum = 1; 
      addMouseListener(this); 
     setDeck(); 
     deckOfPeople.add(farmers);
     deckOfPeople.add(citizens);
     deckOfPeople.add(lords);
     deckOfPeople.add(hermits);
     deckOfPeople.add(knights);
     deckOfPeople.add(discoverers);
     deckOfPeople.add(workers);
     deckOfPeople.add(merchants);
     deckOfPeople.add(miners);
     deckOfPeople.add(fisherman); 
     
     	int numuno = (int)(Math.random()*10);
    	int numdos = (int)(Math.random()*9); 
    	int numtres = (int)(Math.random()*8);
    	kik = deckOfPeople.remove(numuno); 
    	kik2 = deckOfPeople.remove(numdos); 
    	kik3 = deckOfPeople.remove(numtres); //fix this later so it gets numuno, numdos, numtres
    	
    	
    	
    int x = 0;
    	int y = 0;
    	boolean six = false;
    	
    	
    	for (int s = 0; s<4; s++){
    	String [][] list1; 
    	list1 = lists.get(s); 
    	boolean test = false;
    
    	if (s==2)
    	{
 			if (six==false)
 			{
    		x=552;
    		y=0; 
    		six=true; 
 			}
 		}
    	
    	for (int i = 0; i<10; i++)
    	{
    		if (test== false)
    		{
    			test = true;
    		}
    		else
    		{
    			test = false; 
    			x += 27;
    		}
    		for (int b = 0; b<10; b++)
    		{
    			String tempColor = ""; 
    			if (list1[i][b].equals("g"))
    			{
    				tempColor = "lgreen";
    			}
    			if (list1[i][b].equals("dg"))
    				tempColor = "darkgreen"; 
    			if (list1[i][b].equals("b"))
    				tempColor = "blue";
    			if (list1[i][b].equals("c"))
    				tempColor = "city";
    			if (list1[i][b].equals("br"))
    				tempColor = "brown";
    			if (list1[i][b].equals("bl"))
    				tempColor = "black";
    			if (list1[i][b].equals("y"))
    				tempColor = "desert"; 
    			if (list1[i][b].equals("o"))
    				tempColor = "flower"; 
    			int [] theX = {x+27, x, x, x+27, x+55, x+55};  
    			int [] theY = {y, y+15, y+45, y+60, y+45, y+15}; 
    			Polygon2 hex = new Polygon2(theX, theY, 6, tempColor);
    			polygonList.add(hex); 
    			x+=55;

    		}
    		if (s==0||s==1)
    		x=0; 
    		else
    			x=554; 
    			y+=44;  
    	}
    		if (s==0||s==2)
    		y+=4;
    	}
    	
    	
    	
    }

    public Dimension getPreferredSize() {
        
          return new Dimension(1660,970);
       
    }
    
    public boolean moreRedAdjacents(String color)
    {
    	for (int i = 0; i<polygonList.size(); i++)
    	{
    		if (polygonList.get(i).getRed()==true)
    		{
    		
    		ArrayList<Polygon2>temp = polygonList.get(i).getAdjacent(polygonList, i); 
    		for (int b = 0; b<temp.size(); b++)
    		{
    			if (temp.get(b).getColor().equals(color)&&temp.get(b).getRed()==false&&temp.get(b).getBlue()==false)
    			{
    				return true; 
    			}
    		}
    		}
    	}
    	return false; 
    }
    public boolean moreBlueAdjacents(String color)
    {
    	for (int i = 0; i<polygonList.size(); i++)
    	{
    		if (polygonList.get(i).getBlue()==true)
    		{
    		
    		ArrayList<Polygon2>temp = polygonList.get(i).getAdjacent(polygonList, i); 
    		for (int b = 0; b<temp.size(); b++)
    		{
    			if (temp.get(b).getColor().equals(color)&&temp.get(b).getRed()==false&&temp.get(b).getBlue()==false)
    			{
    				return true; 
    			}
    		}
    		}
    	}
    	return false; 
    	
    }
    public void mouseClicked(MouseEvent evt) 
		{ 
		
      		
      		System.out.println("awesome"); 
      		num1 = evt.getX();
      		num2 = evt.getY();
      		this.repaint(); 
		}
    	public void mouseReleased(MouseEvent evt) { }
   		public void mouseEntered(MouseEvent evt) { }
    	public void mouseExited(MouseEvent evt) { } 
    		public void mousePressed (MouseEvent me)
	{}
	public void mouseDragged (MouseEvent me) {}

    public static void main(String[] args) throws IOException  {

        JFrame f = new JFrame("Kingdom Builder");
        
         
        f.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
        Scanner penguin = new Scanner (new File ("Board.in"));
        ArrayList<Board> boards = new ArrayList<Board>(); 
       while (penguin.hasNext())
       {
       	String [][] temp = new String [10][10];
       	for (int i = 0; i<10; i++)
       	{
       		
       		for (int b = 0; b<10; b++)
       		{
       		temp[i][b]=(penguin.next());

       		}
       		
       	}
       	Board theBoard = new Board(temp);
       	boards.add(theBoard);  
       	
       }
   
       	ArrayList<Integer> text = new ArrayList<Integer>();
       	for (int i = 0; i<8; i++)
       	{
       		text.add(i, i); 
       	}
       	Collections.shuffle(text);
       	int theFirst = text.remove(0); 
       	int theSecond = text.remove(1); 
       	int theThird = text.remove(2);
       	int theFourth = text.remove(3); 
       	String [][] uno = boards.get(theFirst).getMatrix();
       	String [][] dos = boards.get(theSecond).getMatrix();
       	String [][] tres = boards.get(theThird).getMatrix();
       	String [][] quatro = boards.get(theFourth).getMatrix();
       	f.add(new LoadImageApp(uno, dos, tres, quatro));
      
      
       f.pack();
       f.setVisible(true);
        
        
        
   }
   
   
   public void fisherman()
   {
   	boolean test2 = false; 
   		for (int i = 0; i<polygonList.size(); i++)
   		{
   			 if (polygonList.get(i).getRed()==true)
   			 {
   			 	ArrayList<Polygon2> temp22 = polygonList.get(i).getAdjacent(polygonList, i);
   			 	test2 = false;  
   			 	for (int b = 0; b<temp22.size(); b++)
   			 	{
   			 		if (temp22.get(b).getColor()=="blue"&&test2 == false)
   			 		{
   			 		
   			 			redScore++;
   			 			test2 = true;
   			 		}
   			 	}
   			 }
   			 else if (polygonList.get(i).getBlue()==true)
   			 {
   			 	ArrayList<Polygon2> temp23 = polygonList.get(i).getAdjacent(polygonList, i);
   			 	test2 = false; 
   			 	for (int b = 0; b<temp23.size(); b++)
   			 	{
   			 		if (temp23.get(b).getColor()=="blue"&&test2 == false)
   			 		{
   			 			blueScore++;
   			 			test2 = true;  
   			 		}
   			 	}
   			 }
   		}
   }
   
   public void miners()
   {
   	boolean test2 = false; 
   	for (int i = 0; i<polygonList.size(); i++)
   		{
   			 if (polygonList.get(i).getRed()==true)
   			 {
   			 	ArrayList<Polygon2> temp22 = polygonList.get(i).getAdjacent(polygonList, i); 
   			 	test2 = false;  	
   			 	for (int b = 0; b<temp22.size(); b++)
   			 	{
   			 		if (temp22.get(b).getColor()=="black"&&test2 == false)
   			 		{
   			 			test2 = true; 
   			 			redScore++;
   			 		}
   			 	}
   			 }
   			 else if (polygonList.get(i).getBlue()==true)
   			 {
   			 	ArrayList<Polygon2> temp23 = polygonList.get(i).getAdjacent(polygonList, i);
   			 	test2 = false;  
   			 	for (int b = 0; b<temp23.size(); b++)
   			 	{
   			 		if (temp23.get(b).getColor()=="black"&&test2 == false)
   			 			{
   			 			test2 = true; 
   			 			blueScore++; 
   			 			}
   			 	}
   			 }
   		}
   }
   
    public void workers()
   	{
   	boolean test2 = false; 
   	for (int i = 0; i<polygonList.size(); i++)
   		{
   			 if (polygonList.get(i).getRed()==true)
   			 {
   			 	ArrayList<Polygon2> temp22 = polygonList.get(i).getAdjacent(polygonList, i); 
   			 	test2 = false;  
   			 	for (int b = 0; b<temp22.size(); b++)
   			 	{
   			 		if (temp22.get(b).getColor()=="city"&&test2 == false)
   			 		{
   			 			test2 = true; 
   			 			redScore++;
   			 		}
   			 	}
   			 }
   			 else if (polygonList.get(i).getBlue()==true)
   			 {
   			 	ArrayList<Polygon2> temp23 = polygonList.get(i).getAdjacent(polygonList, i);
   			 	test2 = false;  
   			 	for (int b = 0; b<temp23.size(); b++)
   			 	{
   			 		if (temp23.get(b).getColor()=="city"&&test2 == false)
   			 		{
   			 			test2 = true; 
   			 			blueScore++; 
   			 		}
   			 	}
   			 }
   		}
   }
   
   public void farmers()
   {
   		blueScore++;
   		redScore++; 
   }
   
   public void citizens()
   {
   		blueScore++;
   		redScore++; 
   }
   
   public void hermits()
   {
   		blueScore++;
   		redScore++; 
   }
   
   public void lords()
   {
   		blueScore++;
   		redScore++; 
   }
   
   public void discoverers()
   {
   		blueScore++;
   		redScore++; 
   }
   
   public void merchants()
   {
   		blueScore++;
   		redScore++; 
   }
   
   public void knights()
   {
   		blueScore++;
   		redScore++; 
   }
   
   
   
   
    
   
	
}