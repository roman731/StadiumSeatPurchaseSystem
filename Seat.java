import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*;
import java.lang.*;
import java.awt.*; 



public class Seat extends JButton {
	public static int[]	PRICING = {74, 47, 32, 19};

	private byte 		section;
	private char 		row;
	private byte 		number;
	private boolean 	selected;
	public boolean[]	sold;

	public Seat(byte s, char r, byte n) {
		section = s;
		row = r;
		number = n;
		selected = false;
		sold = new boolean[4];
    }

    public byte getSection() { return section; }
    public char getRow() { return row; }
    public byte getNumber() { return number; }
    public int getPrice() { return PRICING[section-1]; }
    public boolean isSelected() { return selected; }
    public void setSecleted(boolean s){  selected = s; } 
    public boolean getSold(int x) {return sold[x];}

}