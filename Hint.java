import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hint {
    private JFrame frame;
    private JTextArea questionLabel;
    private JTextField answerField;
    private JButton submitButton;
    private JButton backButton;
    private HintDictionary hintDictionary;
    private WordDictionary wordDictionary;
    private String currentAnswer;
    private boolean isAnswerCorrect;

    // Constructor that takes in a word and "selectedHint"
    public Hint(String selectedHint, String randomWord) {
        hintDictionary = new HintDictionary();
        wordDictionary = new WordDictionary();
        frame = new JFrame("Hint");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 200);

        // Get a random hint from the hint dictionary and save the answer
        HintDictionary.Hint currentHint = hintDictionary.getRandomHint();
        currentAnswer = currentHint.getAnswers().get(0); 

        // If the button the user clicked is the Hint1 button, get the hint1 for the random word. Otherwise, get the hint2 for the word
        String hint = "";
        if (selectedHint.equals("hint1")) {
            hint = wordDictionary.getHint1(randomWord);
        } else if (selectedHint.equals("hint2")) {
            hint = wordDictionary.getHint2(randomWord);
        }

        final String hintToShow = hint;

        // Question label to show the Logic Puzzle
        questionLabel = new JTextArea(currentHint.getHint());
        questionLabel.setFont(new Font("Arial", Font.PLAIN, 18)); // sets the font to Arial, size 24

        questionLabel.setLineWrap(true); // Enable line wrapping
        questionLabel.setWrapStyleWord(true); // Wrap at word boundaries
        questionLabel.setEditable(false); // Disable editing

        // Create the answer text field
        answerField = new JTextField();
        answerField.setPreferredSize(new Dimension(200, 30));

        // Create the Submit button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String answer = answerField.getText();
                 // Check if the answer the user has put in the text_field matches the answer to the Logic Puzzle
                if (hintDictionary.checkAnswer(answer, currentHint)) {
                    isAnswerCorrect = true;
                    JOptionPane.showMessageDialog(frame, "Congratulations, you got it right!");
                    answerField.setText("");
                    JOptionPane.showMessageDialog(frame, hintToShow); // Show the hint for the selected button if they get it right
                    frame.dispose();
                } else {
                    isAnswerCorrect = false;
                    JOptionPane.showMessageDialog(frame, "Sorry, that's incorrect. Please try again.");
                    answerField.setText("");

                }
            }
        });

        // Create a JPanel to hold the answer field and submit button
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(answerField);
        bottomPanel.add(submitButton);

        // Add the question label and bottom panel to the main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(questionLabel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Add the main panel to the frame
        frame.add(mainPanel);

        // Show the frame
        frame.setVisible(true);
    }
}   