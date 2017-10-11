/*
 * A square button in the TicTacToeGUI: This button will contain an int value. The int value determines
 * what the button's text is. The TicTacToeGUI will use 9 of these buttons in an array.
 * 
 * @author (Joey Gudzak)
 * @version (1)
 */
import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Square extends JButton
{
    private String symbol;
    private int value; 
    JRadioButton button;
   
    public Square(int val, ActionListener actionListener)
    {
        this.addActionListener(actionListener);
        value = val;
        symbol = " "; 
    }

    public void setText(int v)
    {
        value = v;
        
        if( v == 11)
        {
        setText ("X");
        }
        else if (v == 12)
        {
        setText("O");
        }
        else 
        {
        setText(v + "");
        }
        
    }
    public JRadioButton getButton(){
        return button;
    } 
    
    public int getValue()
    {
        return value;
   }
    
    

} // end class

