import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GuessWord {
    private JFrame frame;
    private JTextField guessField;
    private JTextArea instructions;
    private JButton submitButton;
    private JButton hint1Button;
    private JButton hint2Button;
    private JButton instructionsButton;
    private JButton scrambleButton;
    private WordDictionary wordDictionary;
    private String currentWord; 
    

    public GuessWord() {
        wordDictionary = new WordDictionary();
        frame = new JFrame("Guess the Word");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        // Get a random word from the word dictionary
        currentWord = wordDictionary.getRandomWordAsString();

        // Create the guess text field
        guessField = new JTextField();
        guessField.setPreferredSize(new Dimension(200, 30));

        // Create the Submit button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String guess = guessField.getText().toUpperCase();

                // Check if the answer the user has put in the text_field matches the random word
                if (guess.equals(currentWord)) {

                    // Ask them if they want to play again. If yes, generate a new random word 
                    int choice = JOptionPane.showConfirmDialog(frame, "Congratulations, you got it right! Do you want to play again?", "Game Over", JOptionPane.YES_NO_OPTION);
                    if (choice == JOptionPane.YES_OPTION) {
                        currentWord = wordDictionary.getRandomWordAsString();
                        guessField.setText("");
                    } else {
                        frame.dispose();
                    }                
                } else {
                    JOptionPane.showMessageDialog(frame, "Sorry, that's incorrect. Please try again.");
                    guessField.setText("");
                }
            }
        });

        // Creating the Instructions button to show instructions

        instructionsButton = new JButton("Instructions");
        instructionsButton.addActionListener(e -> showInstructionsWindow());



        // Create the Hint 1 button that when clicked creates an instance of the Hint class
        hint1Button = new JButton("Hint 1");
        hint1Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Hint hint = new Hint("hint1", currentWord);
            }
        });

    
        // Create the Hint 2 button that when clicked creates an instance of the Hint class
        hint2Button = new JButton("Hint 2");
        hint2Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Hint hint = new Hint("hint2", currentWord);
            }
        });
        
        // Create the Scramble button that scrambles a word
        scrambleButton = new JButton("Scramble");
        scrambleButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        String scrambledWord = scrambleWord(currentWord);
        JOptionPane.showMessageDialog(frame, scrambledWord);
    }
});

        // Create a JPanel to hold the guess field and submit button
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(guessField);
        bottomPanel.add(submitButton);

        // Create a JPanel to hold the hint, scramble and instructions button
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 0));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonPanel.add(hint1Button);
        buttonPanel.add(hint2Button);
        buttonPanel.add(scrambleButton);
        buttonPanel.add(instructionsButton);

        // Add the bottom panel and button panel to the main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        mainPanel.add(buttonPanel, BorderLayout.NORTH);

        // Add the main panel to the frame
        frame.add(mainPanel);

        // Show the frame
        frame.setVisible(true);
    }


    // Method to scramble a word given a word

    private String scrambleWord(String word) {
        char[] chars = word.toCharArray();
        int length = chars.length;
    
        for (int i = 0; i < length; i++) {
            int randomIndex = (int) (Math.random() * length);
    
            // Swap current character with random character
            char temp = chars[i];
            chars[i] = chars[randomIndex];
            chars[randomIndex] = temp;
        }
    
        return new String(chars);
    }

    
// Method to show the instructions window
    public void showInstructionsWindow(){
        JFrame instructionsFrame = new JFrame("Instructions");
        instructionsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        instructionsFrame.setSize(400, 200);
        
        JTextArea instructionsArea = new JTextArea("You have to guess a randomly generated word that is generated at the start. From the 2 hint buttons, if you get the logic puzzle RIGHT, you get a hint corresponding to that word. You have to try to guess the word from that. Also, clicking on the scramble button will scramble the randomly generated word");
        instructionsArea.setFont(new Font("Arial", Font.PLAIN, 14));
        instructionsArea.setLineWrap(true);
        instructionsArea.setWrapStyleWord(true);
        
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                instructionsFrame.dispose(); // close instructions window
            }
        });
        
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(instructionsArea, BorderLayout.CENTER);
        contentPane.add(backButton, BorderLayout.SOUTH);
        
        instructionsFrame.setContentPane(contentPane);
        instructionsFrame.setVisible(true);
    }

    
    // Run the program

    public static void main(String[] args) {
        GuessWord game = new GuessWord();
    }
}








