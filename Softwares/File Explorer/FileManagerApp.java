import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class FileManagerApp extends JFrame {

    private JTextField filePathField;
    private JTextArea logArea;

    public FileManagerApp() {
        // Set up the frame
        setTitle("File Manager Application");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        filePathField = new JTextField(40);
        JButton createButton = new JButton("Create File");
        JButton deleteButton = new JButton("Delete File");
        JButton searchButton = new JButton("Search File");
        JButton openButton = new JButton("Open File");
        logArea = new JTextArea(10, 50);
        logArea.setEditable(false);

        // Add listeners to buttons
        createButton.addActionListener(new CreateFileListener());
        deleteButton.addActionListener(new DeleteFileListener());
        searchButton.addActionListener(new SearchFileListener());
        openButton.addActionListener(new OpenFileListener());

        // Set up panel
        JPanel panel = new JPanel();
        panel.add(new JLabel("File Path:"));
        panel.add(filePathField);
        panel.add(createButton);
        panel.add(deleteButton);
        panel.add(searchButton);
        panel.add(openButton);

        // Add components to frame
        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(logArea), BorderLayout.CENTER);
    }

    // Listener for creating a file
    private class CreateFileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String filePath = filePathField.getText();
            File file = new File(filePath);
            try {
                if (file.createNewFile()) {
                    logArea.append("File created: " + file.getName() + "\n");
                } else {
                    logArea.append("File already exists.\n");
                }
            } catch (IOException ex) {
                logArea.append("Error creating file: " + ex.getMessage() + "\n");
            }
        }
    }

    // Listener for deleting a file
    private class DeleteFileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String filePath = filePathField.getText();
            File file = new File(filePath);
            if (file.delete()) {
                logArea.append("File deleted: " + file.getName() + "\n");
            } else {
                logArea.append("Failed to delete file.\n");
            }
        }
    }

    // Listener for searching a file
    private class SearchFileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String filePath = filePathField.getText();
            File file = new File(filePath);
            if (file.exists()) {
                logArea.append("File found: " + file.getName() + "\n");
            } else {
                logArea.append("File not found.\n");
            }
        }
    }

    // Listener for opening a file
    private class OpenFileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String filePath = filePathField.getText();
            File file = new File(filePath);
            if (file.exists()) {
                try {
                    Desktop.getDesktop().open(file);
                    logArea.append("File opened: " + file.getName() + "\n");
                } catch (IOException ex) {
                    logArea.append("Error opening file: " + ex.getMessage() + "\n");
                }
            } else {
                logArea.append("File not found.\n");
            }
        }
    }

    public static void main(String[] args) {
        // Run the application
        SwingUtilities.invokeLater(() -> {
            FileManagerApp app = new FileManagerApp();
            app.setVisible(true);
        });
    }
}
