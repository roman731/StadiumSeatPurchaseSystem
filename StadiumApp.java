import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*;
 
import java.awt.*; 

public class StadiumApp extends JFrame implements ActionListener, DialogClientInterface  {

//private controls	
JRadioButtonMenuItem rbMenuItem1 = new JRadioButtonMenuItem("Game 1");
JRadioButtonMenuItem rbMenuItem2 = new JRadioButtonMenuItem("Game 2");
JRadioButtonMenuItem rbMenuItem3 = new JRadioButtonMenuItem("Game 3");
JRadioButtonMenuItem rbMenuItem4 = new JRadioButtonMenuItem("Game 4");
JRadioButtonMenuItem rbMenuItem5 = new JRadioButtonMenuItem("All 4 games");


//public controls
public JButton purchaseButton, adminButton;

//public parameters
public StadiumPanel myStadiumPanel;
public SeatInformationPanel SIP;
public SeatPricingPanel SPP;

    public StadiumApp(String name) 
    {
		super(name); 
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Game");
		ButtonGroup group = new ButtonGroup();
		
		rbMenuItem1.setSelected(true);
		
		rbMenuItem1.addActionListener(this);
		rbMenuItem2.addActionListener(this);
		rbMenuItem3.addActionListener(this);
		rbMenuItem4.addActionListener(this);
		rbMenuItem5.addActionListener(this);
		
		group.add(rbMenuItem1); 
		group.add(rbMenuItem2); 
		group.add(rbMenuItem3); 
		group.add(rbMenuItem4); 
		group.add(rbMenuItem5);
		menu.add(rbMenuItem1); 
		menu.add(rbMenuItem2); 
		menu.add(rbMenuItem3); 
		menu.add(rbMenuItem4); 
		menu.add(rbMenuItem5);
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
		
		GridBagLayout layout = new GridBagLayout(); 
		GridBagConstraints constraints = new GridBagConstraints(); 
		getContentPane().setLayout(layout);
		 
		SIP = new SeatInformationPanel("SEAT INFORMATION", this);
		constraints.gridx = 1; 
		constraints.gridy = 0; 
		constraints.gridwidth = 1; 
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL; 
		constraints.weightx = 1; 
		constraints.weighty = 1;
		constraints.insets = new Insets(0, 0, 5, 5);
		constraints.anchor = GridBagConstraints.NORTHEAST; 
		layout.setConstraints(SIP, constraints); 
		getContentPane().add(SIP);
		
		//create SeatPricingPanel
		SPP = new SeatPricingPanel("SELECTED SEAT PRICING", this); 
		constraints.gridx = 1; 
		constraints.gridy = 1;
		constraints.gridwidth = 1; 
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weightx = 1; 
		constraints.weighty = 30;
		constraints.insets = new Insets(0, 0, 5, 5);
		constraints.anchor = GridBagConstraints.NORTHEAST; 
		layout.setConstraints(SPP, constraints); 
		getContentPane().add(SPP); 
		
		// create stadium 
		myStadiumPanel = new StadiumPanel(new Stadium(), this);
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1; 
		constraints.gridheight = 4; 
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.NORTHEAST;
		constraints.ipadx = 0; 
		constraints.ipady = 0; 
		constraints.insets = new Insets(0, 0, 0, 0); 
		constraints.weightx = 0; 
		constraints.weighty = 0;
		layout.setConstraints(myStadiumPanel, constraints); 
		getContentPane().add(myStadiumPanel);
			
		//create Purchase button		
		purchaseButton = new JButton("Purchase");  
		purchaseButton.setEnabled(false);
		purchaseButton.addActionListener(this);
		constraints.gridx = 1; 
		constraints.gridy = 2; 
		constraints.gridwidth = 1; 
		constraints.gridheight = 1; 
		constraints.fill = GridBagConstraints.HORIZONTAL; 
		constraints.insets = new Insets(0, 0, 0, 0); 
		constraints.anchor = GridBagConstraints.NORTHEAST; 
		constraints.weightx = 1; 
		constraints.weighty = 10000; 
		layout.setConstraints(purchaseButton, constraints); 
		getContentPane().add(purchaseButton);
		
		adminButton = new JButton("Administrator");  
		adminButton.addActionListener(this);
		constraints.gridx = 1; 
		constraints.gridy = 3; 
		constraints.gridwidth = 1; 
		constraints.gridheight = 1; 
		constraints.fill = GridBagConstraints.HORIZONTAL; 
		constraints.insets = new Insets(0, 0, 0, 0); 
		constraints.anchor = GridBagConstraints.NORTHEAST; 
		constraints.weightx = 1; 
		constraints.weighty = 1000000; 
		layout.setConstraints(adminButton, constraints); 
		getContentPane().add(adminButton);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE); 

    }
    
    public void actionPerformed(ActionEvent e)
{
	if( e.getSource() == rbMenuItem1 )
	{
		myStadiumPanel.setGameIndex(0);
		myStadiumPanel.resetSelection();
		myStadiumPanel.update();	
	}
	else if (e.getSource() == rbMenuItem2)
	{
		myStadiumPanel.setGameIndex(1);
		myStadiumPanel.resetSelection();
		myStadiumPanel.update();
	}
	else if (e.getSource() == rbMenuItem3)
	{
		myStadiumPanel.setGameIndex(2);
		myStadiumPanel.resetSelection();
		myStadiumPanel.update();
	}
	else if (e.getSource() == rbMenuItem4)
	{
		myStadiumPanel.setGameIndex(3);
		myStadiumPanel.resetSelection();
		myStadiumPanel.update();
	}
	else if (e.getSource() == rbMenuItem5)	
	{
		myStadiumPanel.setGameIndex(myStadiumPanel.ALL_GAMES_INDEX);
		myStadiumPanel.resetSelection();
		myStadiumPanel.update();
	}
	
	else if (e.getSource() == purchaseButton)
	{		
		PurchaseDialog PD = new PurchaseDialog(this,this,this);
		PD.setVisible(true);	
							
	}
	else if (e.getSource() == adminButton)
	{
		AdminLoginDialog dialog = new AdminLoginDialog(this,this, myStadiumPanel.myStadium);
		dialog.setVisible(true);
	}
		
}
public void dialogFinished(){}
public void dialogCancelled(){}
    
	public static void main(String args[]) 
	{ 
		JFrame f = new StadiumApp("Seat Purchasing System");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		f.setSize(820,492);
		f.setResizable(false);
		f.setVisible(true); 
	}

}
