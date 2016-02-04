import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*;
import java.awt.*;


public class SeatInformationPanel extends JPanel
{
	public StadiumApp stadiumApp;
    JTextField sectionField, rowField, numberField, priceField;

    public SeatInformationPanel(String title, StadiumApp _stadiumApp) 
    {
    	super();
    	
    	stadiumApp = _stadiumApp;
    	setLayout(new GridLayout(4,1)); 
    	setBorder(BorderFactory.createTitledBorder("SEAT INFORMATION"));
    	
    	JLabel sectionLabel = new JLabel("Section:           ");
    	add(sectionLabel);
    	
    	sectionField = new JTextField();
    	sectionField.setHorizontalAlignment(JTextField.CENTER);
    	add(sectionField);
    	
    	JLabel rowLabel = new JLabel("Row: ");
    	add(rowLabel);
    	
    	rowField = new JTextField();
    	rowField.setHorizontalAlignment(JTextField.CENTER);
    	add(rowField);
    	
    	JLabel numberLabel = new JLabel("Number: ");
    	add(numberLabel);
    	
    	numberField = new JTextField();
    	numberField.setHorizontalAlignment(JTextField.CENTER);
    	add(numberField);
    	
    	JLabel priceLabel = new JLabel("Price: ");
    	add(priceLabel);
    	
    	priceField = new JTextField();
    	priceField.setHorizontalAlignment(JTextField.CENTER);
    	add(priceField);	 	
    }
    
    
    
    public void setSectionField (String _text)
    {
    	sectionField.setText(_text); 
    }
    
    public void setRowField (String _text)
    {
    	rowField.setText(_text); 
    }
    
    public void setNumberField (String _text)
    {
    	numberField.setText(_text); 
    }
    
    public void setPriceField (String _text)
    {
    	priceField.setText(_text); 
    }
}