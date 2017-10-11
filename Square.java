/**
 * A square button in the TicTacToeGUI: This button will contain an int value. The int value determines
 * what the button's text is. The TicTacToeGUI will use 9 of these buttons in an array.
 * 
 * @author (you)
 * @version (your version)
 */
import javax.swing.*;

public class Square extends JButton
{
    private int value; // possible values 1-9, 11 (X), 12 (O)
    private String symbol; // possible values " ", "X", "O"
    // Extra credit - image icons to use instead of the String symbol
    
    /**
     * Constructor for objects of class Square
     */
    public Square(int v)
    {
        value = v;
        symbol = " ";
        setText(symbol); // inherited JButton method; buttons will be blank until clicked
    }

    /**
     * Sets button's value and corresponding symbol
     * // Extra credit - set button's image icon instead of symbol
     * 
     * @param  s   symbol of button
     */
    public void set(int v)
    {
        // Complete this method
    }

    /**
     * Gets button's value
     */
    public int get()
    {
        return value;
    }

} // end class
