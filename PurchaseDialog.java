import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PurchaseDialog extends JDialog implements ActionListener {
private PurchasePanel myPanel;
private JButton okButton;

private DialogClientInterface client;
StadiumApp myStadiumApp;
PurchasePanel pp;
JButton acceptButton, myCancelButton;
	public PurchaseDialog(Frame owner, DialogClientInterface cli, StadiumApp _stadiumApp){
	
    	super(owner,"Purchase Information",true);
    	myStadiumApp = _stadiumApp;
    	setLayout(null); 
    	pp = new PurchasePanel("test");
    	pp.setSize(360,450);
    	add(pp);

    	acceptButton = new JButton("ACCEPT");
		acceptButton.addActionListener(this);
		acceptButton.setSize(85,30);
		acceptButton.setLocation(175,450);
    	acceptButton.setEnabled(true);
    	add(acceptButton);
    	
    	myCancelButton = new JButton("CANCEL");
		myCancelButton.addActionListener(this);
		myCancelButton.setSize(85,30);
		myCancelButton.setLocation(270,450);
    	myCancelButton.setEnabled(true);
    	add(myCancelButton);
	
    	setResizable(false);
    	setSize(373, 505);
    }
    public void actionPerformed(ActionEvent e)
    {
    	if (e.getSource() == acceptButton)
    	{
    		myStadiumApp.myStadiumPanel.sell();
    		myStadiumApp.myStadiumPanel.update();
    		myStadiumApp.purchaseButton.setEnabled(false);
    		System.out.println("Confirmation of Purchase: ");
    		System.out.println("Name: " + pp.getTextName());
    		System.out.println("Address: " + pp.getTextAddress());
    		System.out.println("City: " + pp.getTextCity());
    		System.out.println("Province: " + pp.getTextProvince());
    		System.out.println("Postal Code: " + pp.getTextPostalCode());
    		System.out.println("Credit Card Type: " + pp.getTextCardType());
    		System.out.println("Expiry Date: " + pp.getTextExpiaryDate());
    		System.out.println("Credit Card Number: " + pp.getTextCardNumber());
    		dispose();
    	}
    	else if(e.getSource() == myCancelButton)
    	{
    		int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel your purchase?", "Cancelation Confirmation", JOptionPane.YES_NO_OPTION); 
    		if (result == 0) 
    			dispose();
    		 else 
    		 	System.out.println();
    	}
    	
   	}
    
    
}