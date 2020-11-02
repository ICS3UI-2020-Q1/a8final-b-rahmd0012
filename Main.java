import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables 
  JPanel mainPanel;

  JButton countButton;
  JButton resetButton;

  JLabel counterLabel;

  JTextField countInput;

  Font biggerText;
 

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Counter");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);

    // initialize the main JPanel
    mainPanel = new JPanel();
    // disable any layout helpers
    mainPanel.setLayout(null);

    // initialize the buttons
    countButton = new JButton("Count");
    resetButton = new JButton("Reset");

    // set the location and size of the buttons 
    countButton.setBounds(200, 50, 200, 30);
    resetButton.setBounds(420, 50, 200, 30);

    // add an action listener to the buttons
    countButton.addActionListener(this);
    resetButton.addActionListener(this);

    // add an action command to the buttons
    countButton.setActionCommand("Count");
    resetButton.setActionCommand("Reset");

    // initialize the counter label 
    counterLabel = new JLabel("Counter:");

    // set the location and size of the counter label
    counterLabel.setBounds(200, 95, 200, 30);

    // initialize the text field 
    countInput = new JTextField("0");

    // set the location and size of the text field
    countInput.setBounds(300, 95, 250, 30);

    // disable the text field so the user cannot type in it
    countInput.setEnabled(false);

    // create a bigger font t0 use 
    biggerText = new Font("arial",Font.PLAIN, 18);

    // set the font to the area I want to use it in 
    countInput.setFont(biggerText);

    // add the count buttons to the main panel
    mainPanel.add(countButton);
    mainPanel.add(resetButton);

    // add the counter label to the main panel
    mainPanel.add(counterLabel);

    // add the count input to the main panel
    mainPanel.add(countInput);

    frame.add(mainPanel);

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    // make the buttons do something when pressed
    if(command.equals("Count")){
      // get the text from the text field
      String countText = countInput.getText();

      // change the string into an integer
      int countNum = Integer.parseInt(countText);
      // create an if statement to count to 10
      if(countNum < 10){
        // add 1 to the counter
        countNum = countNum + 1;
        // show the text in the input
        countInput.setText("" + countNum);
      }
    }else if(command.equals("Reset")){
      // reset the counter input to show 0
      countInput.setText("0");
    }

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
