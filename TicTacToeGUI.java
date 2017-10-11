/**
 * This implementation of TicTacToe uses a 1 dimensional array of 10 elements.
 * Only array indices 1-9 are used. Array index 0 is not used.
 * The untaken TicTacToe squares contain values 1-9. A square taken by "X" contains 11,
 * and a square taken by "O" contains 12. X takes the first turn every time.
 * 
 * @author (you)
 * @version (your version)
 */

// GUI includes:
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TicTacToeGUI extends JFrame
{
    // instance variables
    private int turn; // start at 1, if odd then X's turn, if even then O's turn
    private int xplayer;
    private int oplayer;
    // list of player type constants
    private final int HUMAN = 1;
    private final int MACHINE = 2; // experienced machine player
    // GUI additions:
    // - an array of Square buttons (instead of int); call it 'board'
    // - a game status label

    /**
     * Constructor for objects of class TicTacToe
     */
    public TicTacToeGUI()
    {
        // 1. Create/initialize components:
        //    Construct the 9 Square buttons in the array here; add a SquareButtonListener to each of the 9 buttons.

        
        //    Add three game choice JButtons and add a GameChoiceButtonListener to each button.
        //    Extra credit - Use radio buttons instead of JButtons

        
        // 2. Create content panels, set layouts:
        //    Need at least 2 panels
        //    - 1 panel for 9 Square buttons
        //    - 1 panel for game status label and game choice buttons

        
        // 3. Add the components to the content panels.
        
        
        // 4. Set this window's attributes, and pack it.

        
    } // end constructor

    
    
    
    /**
     * Square button listener; to be added to 9 Square buttons;
     * Used only by a human player.
     */
    class SquareButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
        }
    }// end listener inner class

    
    
    
    /**
     * Game choice button listener; to be added to 3 game choice buttons
     */
    class GameChoiceButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
        }    
    } // end listener inner class
    
    
    

    /**
     * Set up new game.
     * Needs to be called from the GameChoiceButtonListener to start new games.
     * Set turn to 1.
     * Reset 9 Square Buttons in array to values 1-9.
     */
    private void setupNewGame()
    {
    }

    
    
    
    /**
     * Method to play as machine.
     * There's no loop.
     * It will call the getMachineSquare() method to get a square number to take and then take that square number.
     * If it's a machine(X) vs human(O) game, it must be called from the GameChoiceButtonListener to start the game.
     * If it's a machine(X) vs human(O) game or human(X) vs machine(O) game, it must be called from the 
     *      SquareButtonListener after a human player take a turn.
     */
    private void machinePlay()
    {        
    }

    
    
    
    /**
     * Display game status in game status label.
     * Display whose turn it is, who has won or whether it's a draw.
     * It must be called from the SquareButtonListener and the machinePlay() method.
     */
    private void setGameStatusLabel()
    {        
    } // end setGameStatusLabel()

    
    

    
    /*
     * 
     * 
     * The following methods are from the non-GUI TicTacToe project. They must be altered in some places for the 
     * TicTacToeGUI project. Mainly, they need to be changed to take into account the fact that TicTacToeGUI's board
     * array is an array of Square buttons, not an array of ints.
     * 
     * 
     */
    
    
    
    
    /**
     * takeSquare: Method to put "X" or "O" in one of the 9 Square buttons
     * Place an "X" or "O" in the square indicated by squareNumber, depending on the value of turn.
     * Called from machinePlay() or from the SquareButtonListener.
     *
     * @param squareNumber (number from 1 - 9)
     */
    private void takeSquare(int squareNumber)
    {
        if (turn % 2 != 0) {
            board[squareNumber] = 11; // X
        }
        else {
            board[squareNumber] = 12; // O
        }
    }

    
    
    
    /**
     * validSquare: Method to check if input squareNumber is valid.
     * A squareNumber is valid if it's between 1-9 AND
     * if the board[squareNumber] does not contain an 11 (X) or 12 (O).
     * 
     * @param squareNumber
     * @return valid, true if valid, false if invalid
     */
    private boolean validSquare(int squareNumber)
    {
        boolean valid = true;

        if (squareNumber < 1 || squareNumber > 9) {
            valid = false;
        }

        if (board[squareNumber] > 10) {
            valid = false;
        }

        return valid;
    }

    
    
    
    /**
     * hasWon: Check for game won. Called at the end a turn.
     *         If this method returns true, X or O has won.
     * @return won, true or false
     */
    private boolean hasWon()
    {
         boolean won = false;
         
         // I'm using as compact a coding style as I can below:
         
         // rows
         if ( board[1] == board[2] && board[2] == board[3] ) won = true;
         if ( board[4] == board[5] && board[5] == board[6] ) won = true;
         if ( board[7] == board[8] && board[8] == board[9] ) won = true;
         // columns
         if ( board[1] == board[4] && board[4] == board[7] ) won = true;
         if ( board[2] == board[5] && board[5] == board[8] ) won = true;
         if ( board[3] == board[6] && board[6] == board[9] ) won = true;
         // diagonals
         if ( board[1] == board[5] && board[5] == board[9] ) won = true;
         if ( board[3] == board[5] && board[5] == board[7] ) won = true;
         
         return won;
    }

    
    
        
    /**
     * getMachineSquare: This method contains an algorithm through which the
     *                   computer will choose a valid square number to take to
     *                   win the game or to prevent the opponent from winning
     *                   the game. The computer can be playing either X or O.
     *                   This represents an experienced machine type player.
     * @return squareNumber, a valid squareNumber from 1-9
     */
    private int getMachineSquare()
    {
        int mySymbol;
        int oppoSymbol;

        if (turn % 2 != 0) {
            mySymbol = 11; // X
            oppoSymbol = 12;
        }
        else{
            mySymbol = 12; // O
            oppoSymbol = 11;
        }

        // Experienced X, first turn, so choose corners (1, 3, 7, 9) or center (5):
        if (turn == 1)
        {
            int i = (int)(Math.random() * 5); // range: 0-4
            return (i + i) + 1; // returns 1, 3, 5, 7 or 9; skips rest of method
        }

        // Experienced O, second turn, so choose corners or center:
        if (turn == 2)
        {
            int sq = 0;

            if (validSquare(5))
            {
                sq = 5; // center is open, so take it
            }
            else // take a corner (1, 3, 7 or 9)
            {
                while(true)
                {
                    int i = (int)(Math.random() * 5);
                    sq = (i + i) + 1;

                    if (sq != 5)
                    {
                        break; // if not center (5), break
                    }
                }
            }

            return sq; // returns 1, 3, 5, 7 or 9; skips rest of method
        }

        //
        // 1) Try to win if my win is imminent
        //
        for (int i = 1; i <= 9; i++)
        {
            // If square i not taken...
            if (validSquare(i))
            {
                // Take the square
                board[i] = mySymbol;
                // If taking the square wins me the game...
                if (hasWon())
                {
                    // I'll take that square to win.
                    return i; // skip rest of method
                }
                else
                {
                    // I'll put the number back and check the next square.
                    board[i] = i;
                }
            } // end if
        } // end for

        //
        // 2) Try to block if an opponent win is imminent
        //
        for (int i = 1; i <= 9; i++)
        {
            // If square i not taken...
            if (validSquare(i))
            {
                // Let opponent take the square
                board[i] = oppoSymbol;
                // If taking the square wins my opponent the game...
                if (hasWon())
                {
                    // I'll that square to block.
                    return i; // skip rest of method
                }
                else
                {
                    // I'll put the number back and check the next square.
                    board[i] = i;
                }
            } // end if
        } // end for

        //
        // 3) Last resort: Play like a novice by choosing a random square that is available.
        //
        return getNoviceSquare(); // See getNoviceSquare() method definition below

    } // end getMachineSquare()

    
    
    
    /**
     * getNoviceSquare: Returns a random untaken square.
     *                  This represents a novice machine type player.
     * @return squareNumber, a valid squareNumber from 1-9
     */
    private int getNoviceSquare()
    {
        int squarenum;

        while(true) {
            squarenum = (int)(Math.random() * 9) + 1; // range: 1-9
            if (validSquare(squarenum)) {
                break;
            }
        }

        return squarenum;
    }    

    
    
    
    public static void main(String[] args) {
        TicTacToeGUI window = new TicTacToeGUI();
        window.setVisible(true);
    }    

} // end class
