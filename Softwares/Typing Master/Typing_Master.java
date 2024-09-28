
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Typing_Master extends JFrame {
    private JTextArea sentenceArea;
    private JTextField inputField;
    private JButton startButton;
    private JLabel accuracyLabel;
    private JLabel speedLabel;
    private long startTime;
    private int totalCharsTyped;

    private String[] sentences = {
        "The quick brown fox jumps over the lazy dog.",
        "Java is a high-level programming language.",
        "Swing is a part of Java Foundation Classes.",
        "Learning to type is essential in the digital age.",
        "Practice makes perfect in typing."
    };

    public Typing_Master() {
        setTitle("Typing Master");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        sentenceArea = new JTextArea(3, 40);
        sentenceArea.setLineWrap(true);
        sentenceArea.setWrapStyleWord(true);
        sentenceArea.setEditable(false);
        sentenceArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        add(new JScrollPane(sentenceArea));

        inputField = new JTextField(40);
        inputField.setFont(new Font("Monospaced", Font.PLAIN, 16));
        inputField.addActionListener(new TypingAction());
        add(inputField);

        startButton = new JButton("Start");
        startButton.addActionListener(new StartButtonListener());
        add(startButton);

        accuracyLabel = new JLabel("Accuracy: 0%");
        add(accuracyLabel);

        speedLabel = new JLabel("Speed: 0 WPM");
        add(speedLabel);
    }

    private class StartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            startPractice();
        }
    }

    private void startPractice() {
        Random random = new Random();
        int index = random.nextInt(sentences.length);
        String sentence = sentences[index];
        sentenceArea.setText(sentence);
        inputField.setText("");
        inputField.requestFocus();
        startTime = System.currentTimeMillis();
        totalCharsTyped = 0;
    }

    private class TypingAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = inputField.getText();
            String correctSentence = sentenceArea.getText();

            totalCharsTyped = input.length();
            int correctChars = 0;

            for (int i = 0; i < Math.min(input.length(), correctSentence.length()); i++) {
                if (input.charAt(i) == correctSentence.charAt(i)) {
                    correctChars++;
                }
            }

            double accuracy = (double) correctChars / correctSentence.length() * 100;
            accuracyLabel.setText(String.format("Accuracy: %.2f%%", accuracy));

            long timeTaken = System.currentTimeMillis() - startTime;
            double minutesTaken = timeTaken / 60000.0;
            double speed = (totalCharsTyped / 5.0) / minutesTaken; // Words per minute

            speedLabel.setText(String.format("Speed: %.2f WPM", speed));

            if (input.equals(correctSentence)) {
                JOptionPane.showMessageDialog(Typing_Master.this, "Well done! You've completed the sentence.");
                startPractice();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Typing_Master app = new Typing_Master();
            app.setVisible(true);
        });
    }
}
