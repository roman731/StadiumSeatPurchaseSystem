import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*;
import java.awt.*;


public class SeatPricingPanel extends JPanel {
JTextField priceField, hstField, costField;
public StadiumApp stadiumApp;
    public SeatPricingPanel(String title, StadiumApp _stadiumApp) 
    {
    	super();
     	stadiumApp = _stadiumApp; 	

    	setLayout(new GridLayout(3,1)); 
    	setBorder(BorderFactory.createTitledBorder("SELECTED SEAT PRICING"));
    	
    	
    	JLabel priceLabel = new JLabel("Seat(s) Price: ");
    	add(priceLabel);
    	
    	priceField = new JTextField();
    	priceField.setHorizontalAlignment(JTextField.RIGHT);
    	add(priceField);
    	
    	JLabel hstLabel = new JLabel("HST: ");
    	add(hstLabel);
    	
    	hstField = new JTextField();
    	hstField.setHorizontalAlignment(JTextField.RIGHT);
    	add(hstField);
    	
    	JLabel costLabel = new JLabel("Total Cost: ");
    	add(costLabel);
    	
    	costField = new JTextField();
    	costField.setHorizontalAlignment(JTextField.RIGHT);
    	add(costField);
    	
    }    
    	
    public void setPriceFields (float price, float hst, float total)
    {
    	priceField.setText(String.format("$%1.2f", price));
		hstField.setText(String.format("$%1.2f", hst));
		costField.setText(String.format("$%1.2f", total));
    }
}