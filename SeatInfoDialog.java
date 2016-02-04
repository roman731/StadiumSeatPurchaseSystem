import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class SeatInfoDialog extends JDialog implements ActionListener {
	private JButton 		okButton;
	private JTextField 		userTextField;
	private JPasswordField  passwordField;
	AdminLoginDialog thisAdminLoginDialog;
	Stadium thisStadium;
	int counter = 0;
	float price = 0;
	
	public SeatInfoDialog(Stadium stadium){
		super((JDialog)null,"Administrator Sales Report",true);
		
		thisStadium = stadium;
		
		
		int gameOneTicketsSold = ticketsSoldCounter(0);
		int gameTwoTicketsSold = ticketsSoldCounter(1);
		int gameThreeTicketsSold = ticketsSoldCounter(2);
		int gameFourTicketsSold = ticketsSoldCounter(3);
		
		float gameOneTotalPrice = ticketsPriceCounter(0);
		float gameTwoTotalPrice = ticketsPriceCounter(1);
		float gameThreeTotalPrice = ticketsPriceCounter(2);
		float gameFourTotalPrice = ticketsPriceCounter(3);
	
		
		// Add the components
        	setLayout(new GridLayout(8,3));

   		JLabel aLabel = new JLabel("GAME");
   		aLabel.setHorizontalAlignment(JLabel.CENTER);
		add(aLabel);
		aLabel = new JLabel("SEATS SOLD");
   		aLabel.setHorizontalAlignment(JLabel.CENTER);
		add(aLabel);
		aLabel = new JLabel("SALES");
   		aLabel.setHorizontalAlignment(JLabel.CENTER);
		add(aLabel);
		
		JLabel gameOneLabel = new JLabel("1");
		gameOneLabel.setHorizontalAlignment(JLabel.CENTER);
		add(gameOneLabel);
		 
		JLabel seatOneLabel = new JLabel();
		seatOneLabel.setText(String.valueOf(gameOneTicketsSold));
		seatOneLabel.setHorizontalAlignment(JLabel.CENTER);
		add(seatOneLabel);
		
		JLabel salesOneLabel = new JLabel();
		salesOneLabel.setText("$"+String.valueOf(gameOneTotalPrice));
		salesOneLabel.setHorizontalAlignment(JLabel.CENTER);
		add(salesOneLabel);
		///////////////////////////////////////////////
		JLabel gameTwoLabel = new JLabel("2");
		gameTwoLabel.setHorizontalAlignment(JLabel.CENTER);
		add(gameTwoLabel);
		
		JLabel seatTwoLabel = new JLabel();
		seatTwoLabel.setText(String.valueOf(gameTwoTicketsSold));
		seatTwoLabel.setHorizontalAlignment(JLabel.CENTER);
		add(seatTwoLabel);
		
		JLabel salesTwoLabel = new JLabel();
		salesTwoLabel.setText("$"+String.valueOf(gameTwoTotalPrice));
		salesTwoLabel.setHorizontalAlignment(JLabel.CENTER);
		add(salesTwoLabel);
		/////////////////////////////////////////////////
		JLabel gameThreeLabel = new JLabel("3");
		gameThreeLabel.setHorizontalAlignment(JLabel.CENTER);
		add(gameThreeLabel);
		
		JLabel seatThreeLabel = new JLabel();
		seatThreeLabel.setText(String.valueOf(gameThreeTicketsSold));
		seatThreeLabel.setHorizontalAlignment(JLabel.CENTER);
		add(seatThreeLabel);
		
		JLabel salesThreeLabel = new JLabel();
		salesThreeLabel.setText("$"+String.valueOf(gameThreeTotalPrice));
		salesThreeLabel.setHorizontalAlignment(JLabel.CENTER);
		add(salesThreeLabel);
		///////////////////////////////////////////////////
		JLabel gameFourLabel = new JLabel("4");
		gameFourLabel.setHorizontalAlignment(JLabel.CENTER);
		add(gameFourLabel);	
		
		JLabel seatFourLabel = new JLabel();
		seatFourLabel.setText(String.valueOf(gameFourTicketsSold));
		seatFourLabel.setHorizontalAlignment(JLabel.CENTER);
		add(seatFourLabel);
		
		JLabel salesFourLabel = new JLabel();
		salesFourLabel.setText("$"+String.valueOf(gameFourTotalPrice));
		salesFourLabel.setHorizontalAlignment(JLabel.CENTER);
		add(salesFourLabel);
			
		

		aLabel = new JLabel("-------------------");
		aLabel.setHorizontalAlignment(JLabel.CENTER);
		add(aLabel);
		aLabel = new JLabel("-------------------");
		aLabel.setHorizontalAlignment(JLabel.CENTER);
		add(aLabel);
		aLabel = new JLabel("-------------------");
		aLabel.setHorizontalAlignment(JLabel.CENTER);
		add(aLabel);

		aLabel = new JLabel("TOTAL");
		aLabel.setHorizontalAlignment(JLabel.CENTER);
		add(aLabel);
		JLabel totalGamesLabel = new JLabel();
		totalGamesLabel.setText(Integer.toString(gameOneTicketsSold+gameTwoTicketsSold+gameThreeTicketsSold+gameFourTicketsSold));
		totalGamesLabel.setHorizontalAlignment(JLabel.CENTER);
		add(totalGamesLabel);
		aLabel = new JLabel();
		aLabel.setText("$"+Float.toString(gameOneTotalPrice+gameTwoTotalPrice+gameThreeTotalPrice+gameFourTotalPrice));
		aLabel.setHorizontalAlignment(JLabel.CENTER);
		add(aLabel);

        aLabel = new JLabel("");	
		add(aLabel);
		aLabel = new JLabel("");	
		add(aLabel);
        add(okButton = new JButton("OK"));
        okButton.addActionListener(this);
        
		setSize(300, 240);
		setResizable(false);
			
	}
	public void actionPerformed(ActionEvent e)
         {
         	if (e.getSource() == okButton)
         	{
         		dispose();
         	}
         }

	public int ticketsSoldCounter(int gameIndex)
	{
		counter = 0;
		for (int i=0; i<27; i++)
		{	
			for (int j=0; j<35; j++)
			{
				if(thisStadium.getSeat(i,j) != null)
				{
					if (thisStadium.getSeat(i,j).sold[gameIndex])
					{
						counter++;
					}
				}			
			}
		}
		return counter;
	}
	
	public float ticketsPriceCounter(int gameIndex)
	{
		counter = 0;
		price = 0;
			for (int i=0; i<27; i++)
			{	
				for (int j=0; j<35; j++)
				{
					if(thisStadium.getSeat(i,j) != null)
					{
						if (thisStadium.getSeat(i,j).sold[gameIndex])
						{
							price += (thisStadium.getSeat(i,j).getPrice());
						}
					}			
				}
			}
	
		return (price*1.13f);
	}
	
}
