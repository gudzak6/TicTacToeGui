/**
 * This implementation of TicTacToe uses a 1 dimensional array of 10 elements.
 * Only array indices 1-9 are used. Array index 0 is not used.
 * The untaken TicTacToe squares contain values 1-9. A square taken by "X" contains 11,
 * and a square taken by "O" contains 12. X takes the first turn every time.
 * 
 * @author (Joey Gudzak)
 * @version (1)
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JApplet;

public class TicTacToeGUI extends JFrame
{
    // instance variables
    private int turn; // start at 1, if odd then X's turn, if even then O's turn
    // list of player type constants
    private final int HUMAN = 1;
    private final int MACHINE = 2;
    // - an array of Square buttons (instead of int); call it 'board'
    Square[] board = new Square[10];
    JLabel label = new JLabel("Game Status");
    JRadioButton addButton;
    JRadioButton addButton1;
    JRadioButton addButton2;
    
    JLabel Status;
    JRadioButton button;
    /**
     * Constructor for objects of class TicTacToe
     */
    public TicTacToeGUI()
    {
        // 1. Create/initialize components:
        JPanel tictactoe = new JPanel();
        tictactoe.setLayout(new GridLayout(3,3));
        for (int i = 1 ; i < 10 ; i++)
        {
           board[i] =  new Square(i, new SquareButtonListener());
           tictactoe.add(board[i]);
        }

        //Add three game choice JButtons and add a GameChoiceButtonListener to each button.
        addButton = new JRadioButton("Human vs Human");
        addButton.addActionListener(new GameChoiceButtonListener());
        addButton1 = new JRadioButton("Human vs Machine");
        addButton1.addActionListener(new GameChoiceButtonListener());
        addButton2 = new JRadioButton("Machine vs Human");
        addButton2.addActionListener(new GameChoiceButtonListener());
        
        Status = new JLabel("Choose a game below to start:");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10,1));
        panel.add(Status);
        panel.add(addButton);
        panel.add(addButton1);
        panel.add(addButton2);
       
        setLayout(new GridLayout(2,1));
        add(tictactoe);
        add(panel);

        // Layout components.
        pack();                               
        setTitle("TicTacToe GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        
    } // end constructor
     
    /**
     * Square button listener; to be added to 9 Square buttons;
     * Used only by a human player.
     */
    class SquareButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(turn < 9){
            if(button == addButton){
                setGameStatusLabel();
                for(int i = 0; i < board.length; i++){
                    if(e.getSource() == board[i]){
                        if(validSquare(i)){                       
                            takeSquare(i);
                            turn++;
                        }
                    }
                }
                setGameStatusLabel();
            }
            if(button == addButton1){
                setGameStatusLabel();
                for(int i = 0; i < board.length; i++){
                    if(e.getSource() == board[i]){
                        if(validSquare(i)){                       
                            takeSquare(i);
                            turn++;
                        }
                    }
                }
                machinePlay();
                turn++;
                setGameStatusLabel();
            }
    }
   }
   
    }// end listener inner class

    /**
     * Game choice button listener; to be added to 3 game choice buttons
     */
    class GameChoiceButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            newGame();
            if (e.getSource() == addButton)
            {
                button = addButton;
            }
            if (e.getSource() == addButton1)
            {
                button = addButton1;
            }
            if (e.getSource() == addButton2)
            {
                button = addButton1;
                machinePlay();
                turn++;
            }  
        } // end listener inner class
    }
    /**
     * Set up new game.
     * Needs to be called from the GameChoiceButtonListener to start new games.
     * Set turn to 1.
     * Reset 9 Square Buttons in array to values 1-9.
     */
    private void newGame()
    {
        turn = 1;
        for(int i = 1; i < board.length;i++)
       {
            board[i].setText(i);
        }

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
        takeSquare(getMachineSquare());
    }

    /**
     * Display game status in game status label.
     * Display whose turn it is, who has won or whether it's a draw.
     * It must be called from the SquareButtonListener and the machinePlay() method.
     */
    private void setGameStatusLabel()
    {
          
        if(hasWon()){
                
               if(turn % 2 != 0)
              {
                  Status.setText("Game over, O has won the game.");
                }
                else{
                   Status.setText("Game Over, X has won the game.");
                }
       
        }
        else if(turn == 9){
            Status.setText("Draw");
        }
        else if(turn % 2 != 0)
        {
            Status.setText("X's turn");
        }
        else{
            Status.setText("O's turn");
        }
        
    } // end setGameStatusLabel()

    /*
     * The following methods are from the non-GUI TicTacToe project. They must be altered in some places for the 
     * TicTacToeGUI project. Mainly, they need to be changed to take into account the fact that TicTacToeGUI's board
     * array is an array of Square buttons, not an array of ints.
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
            board[squareNumber].setText(11); // X
        }
        else {
            board[squareNumber].setText(12); // O
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

        if (squareNumber < 0 || squareNumber > 9) {
            valid = false;
        }

        if (board[squareNumber].getValue() > 10) {
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
        // rows
        if ( board[1].getValue() == board[2].getValue() && board[2].getValue() == board[3].getValue()) won = true;
        if ( board[4].getValue() == board[5].getValue() && board[5].getValue() == board[6].getValue()) won = true;
        if ( board[7].getValue() == board[8].getValue() && board[8].getValue() == board[9].getValue()) won = true;
        // columns
        if ( board[1].getValue() == board[4].getValue() && board[4].getValue() == board[7].getValue()) won = true;
        if ( board[2].getValue() == board[5].getValue() && board[5].getValue() == board[8].getValue()) won = true;
        if ( board[3].getValue() == board[6].getValue() && board[6].getValue() == board[9].getValue()) won = true;
        // diagonals
        if ( board[1].getValue() == board[5].getValue() && board[5].getValue() == board[9].getValue()) won = true;
        if ( board[3].getValue() == board[5].getValue() && board[5].getValue() == board[7].getValue()) won = true;

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
            int square = 0;

            if (validSquare(5))
            {
                square = 5; // center is open, so take it
            }
            else // take a corner (1, 3, 7 or 9)
            {
                while(true)
                {
                    int i = (int)(Math.random() * 5);
                    square = (i + i) + 1;

                    if (square != 5)
                    {
                        break; // if not center (5), break
                    }
                }
            }

            return square; // returns 1, 3, 5, 7 or 9; skips rest of method
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
                board[i].setText(mySymbol);
                // If taking the square wins me the game...
                if (hasWon())
                {
                    // I'll take that square to win.
                    return i; // skip rest of method
                }
                else
                {
                    // I'll put the number back and check the next square.
                    board[i].setText(i);
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
                board[i].setText(oppoSymbol);
                // If taking the square wins my opponent the game...
                if (hasWon())
                {
                    // I'll that square to block.
                    return i; // skip rest of method
                }
                else
                {
                    // I'll put the number back and check the next square.
                    board[i].setText(i);
                }
            } // end if
        } // end for

        return getNoviceSquare(); 

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
}