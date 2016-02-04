import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class StadiumPanel extends BoardPanel implements MouseListener, ActionListener {

public Stadium myStadium;
public StadiumApp stadiumApp;
public SeatInformationPanel seatInformationPanel;
public SeatPricingPanel seatPricingPanel;
public float price;
public final int ALL_GAMES_INDEX = 4;

public Seat[][] myButtonArray;
int gameIndex;
public void setGameIndex(int x){ gameIndex = x; }

    public StadiumPanel( Stadium _stadium, StadiumApp _stadiumApp  ) 
    {
    	myStadium = _stadium;
    	stadiumApp = _stadiumApp;
    	seatInformationPanel = stadiumApp.SIP;
    	seatPricingPanel = stadiumApp.SPP;
    	
		setLayout(new GridLayout(27,35,0,0)); 
		myButtonArray = myStadium.getSeats();

	for (int i=0; i<27; i++) 
		for (int j=0; j<35; j++) 
		{ 
			if(myButtonArray[i][j] != null)
			{	
				add(myButtonArray[i][j]); 
				myButtonArray[i][j].addMouseListener(this);
				myButtonArray[i][j].addActionListener(this);
			}
			else
			{
				JLabel myLabel = new JLabel();
				add(myLabel);				
			}
		} 	
			update(); 	
    }
    
    //override the methods of implemented MouseListener
 
public void mouseClicked(MouseEvent e) { }
 
public void mousePressed(MouseEvent e) { }
 
public void mouseReleased(MouseEvent e) { }
 
public void mouseEntered(MouseEvent e) { 
	
	if( e.getSource() instanceof Seat ) 
	{
		Seat seat = (Seat) e.getSource();
	    seatInformationPanel.setSectionField(Byte.toString(seat.getSection()));
	    
	    seatInformationPanel.setRowField(Character.toString(seat.getRow()));
	    
	    seatInformationPanel.setNumberField(Byte.toString(seat.getNumber()));
	    
	    seatInformationPanel.setPriceField("$" + Integer.toString(seat.getPrice()) + ".00");
	    
	}
	
}
 
public void mouseExited(MouseEvent e) 
{  
	if( e.getSource() instanceof Seat ) 
	{
		Seat seat = (Seat) e.getSource(); 
	    seatInformationPanel.setSectionField("");
	    seatInformationPanel.setRowField("");
	    seatInformationPanel.setNumberField("");
	    seatInformationPanel.setPriceField("");
	}
}

public void actionPerformed(ActionEvent e)
{
	if( e.getSource() instanceof Seat )
	{
		Seat seat = (Seat) e.getSource();
		if (seat.isSelected())
		{
			seat.setSecleted(false);
			if (checkButtons())
			{
				stadiumApp.purchaseButton.setEnabled(false);
			}
		}
		else if (seat.getBackground() != Color.white)
		{
			seat.setSecleted(true);
			stadiumApp.purchaseButton.setEnabled(true);
			
		}			
		update();		
	}
}

public void resetSelection()
{
	for (int i=0; i<27; i++) 
		for (int j=0; j<35; j++)
		{
			if(myButtonArray[i][j] != null)
			{
				myButtonArray[i][j].setSecleted(false);
			}
		}
}
//check to see if theres any buttons that are currently selected
public boolean checkButtons()
{
	for (int i=0; i<27; i++) 
		for (int j=0; j<35; j++)
		{
			if(myButtonArray[i][j] != null)
			{
				if (myButtonArray[i][j].isSelected())
					return false;
			}	
		}
	return true;
}

	
public void update()
{	price = 0; 
	for (int i=0; i<27; i++) 
		for (int j=0; j<35; j++)
		{
			if(myButtonArray[i][j] != null)
			{
				    if ( gameIndex < ALL_GAMES_INDEX && myButtonArray[i][j].sold[gameIndex])
				    {
				    	myButtonArray[i][j].setBackground(Color.WHITE);
				    }
				    else if (gameIndex == ALL_GAMES_INDEX && (
				    	myButtonArray[i][j].sold[0] || myButtonArray[i][j].sold[1] || myButtonArray[i][j].sold[2] || myButtonArray[i][j].sold[3]
				    	)  )
				    {
				    	myButtonArray[i][j].setBackground(Color.WHITE); 
				    }
				    else if (myButtonArray[i][j].isSelected())
					{
						myButtonArray[i][j].setBackground(Color.GRAY); 	
						price += myButtonArray[i][j].getPrice();
					}
					else 
					{	
						if (myButtonArray[i][j].getSection() == 1) 
							myButtonArray[i][j].setBackground(Color.red); 
						else if (myButtonArray[i][j].getSection() == 2)
							myButtonArray[i][j].setBackground(Color.green); 
						else if (myButtonArray[i][j].getSection() == 3)
							myButtonArray[i][j].setBackground(Color.blue);
						else if (myButtonArray[i][j].getSection() == 4)
							myButtonArray[i][j].setBackground(Color.yellow);
					}
			}
		}
	   calculatePriceFields(price);	
		}
   
	public void sell()
	{
		for (int i=0; i<27; i++) 
				for (int j=0; j<35; j++) 
				{ 
					if(myButtonArray[i][j] != null && myButtonArray[i][j].isSelected())
					{
						if (gameIndex == ALL_GAMES_INDEX)
						{
							myButtonArray[i][j].sold[0] = true;
							myButtonArray[i][j].sold[1] = true;
							myButtonArray[i][j].sold[2] = true;
							myButtonArray[i][j].sold[3] = true;
						}
						else
						{								
							myButtonArray[i][j].sold[gameIndex] = true;	
						}
					
							myButtonArray[i][j].setSecleted(false);	
					}
				}
						
	
		update();	
	}
	
	public void calculatePriceFields (float price)
    {
    	if( gameIndex != ALL_GAMES_INDEX)
	    {
	    	float hst = price*1.13f-price;
		    float totalPrice = price + hst;
		    //show fields
		    seatPricingPanel.setPriceFields ( price, hst, totalPrice);
		}
	    else
	    {
	    	float newPrice = price*4f*0.9f;
	    	float hst = newPrice*1.13f-newPrice;
	    	float totalPrice = newPrice + hst;
	    	//show fields
	    	seatPricingPanel.setPriceFields (newPrice, hst, totalPrice);
	    }
    }

}