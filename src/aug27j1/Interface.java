package aug27j1;

import javax.swing.*;
import java.awt.*;

public class Interface extends JFrame {

    // Colors based on the current design
    private static final Color DARK_GRAY = new Color(65, 65, 65);
    private static final Color PANEL_GRAY = new Color(184, 184, 184);
    private static final Color SILVER = new Color(220, 224, 230);
    private static final Color BLACK = new Color(0, 0, 0);
    private static final Color NEON_PINK = new Color(255, 40, 100);
    private static final Color MATRIX_GREEN = new Color(0, 255, 70);
    private static final Color WHITE = new Color(245, 245, 245);

    // GUI components
    private JLabel roomNameLabel;
    private JTextArea roomDescriptionArea;
    private JTextArea messageArea;
    private JTextField commandField;

    public Interface() {
        // Window settings
        setTitle("Get to the Car!");
        setSize(1000, 750);
        setMinimumSize(new Dimension(700, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(0, 0));
        getContentPane().setBackground(BLACK);

        // =====================================
        // TOP: GAME TITLE
        // =====================================
        JLabel titleLabel = new JLabel("Get to the Car!", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.PLAIN, 76));
        titleLabel.setForeground(new Color(225, 50, 245));

        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(DARK_GRAY);
        titlePanel.setPreferredSize(new Dimension(100, 180));
        titlePanel.add(titleLabel, BorderLayout.CENTER);
        add(titlePanel, BorderLayout.NORTH);

        // =====================================
        // LEFT SIDE: ROOM NAME AND DESCRIPTION
        // =====================================
        JPanel leftPanel = new JPanel(new BorderLayout(0, 5));
        leftPanel.setBackground(SILVER); // Silver shows through as dividers
        // Add silver connector lines along the top, right, and bottom edges.
        // The right edge sits beside the black gap between the two columns.
        leftPanel.setBorder(
            BorderFactory.createMatteBorder(2, 0, 2, 2, SILVER)
        );

        // Compact header section; the description gets the remaining space
        JPanel roomHeaderSection = new JPanel();
        roomHeaderSection.setLayout(new BoxLayout(roomHeaderSection, BoxLayout.Y_AXIS));
        roomHeaderSection.setBackground(SILVER);

        JLabel roomHeading = new JLabel("Room", SwingConstants.CENTER);
        styleHeading(roomHeading, 42, WHITE);
        roomHeaderSection.add(makeHeaderPanel(roomHeading, 62));
        roomHeaderSection.add(Box.createRigidArea(new Dimension(0, 5)));

        roomNameLabel = new JLabel("Room Name", SwingConstants.CENTER);
        roomNameLabel.setFont(new Font("SansSerif", Font.PLAIN, 28));
        roomNameLabel.setForeground(NEON_PINK);
        roomHeaderSection.add(makeHeaderPanel(roomNameLabel, 82));
        roomHeaderSection.add(Box.createRigidArea(new Dimension(0, 5)));

        JLabel descriptionHeading = new JLabel("Description", SwingConstants.CENTER);
        styleHeading(descriptionHeading, 42, WHITE);
        roomHeaderSection.add(makeHeaderPanel(descriptionHeading, 68));

        leftPanel.add(roomHeaderSection, BorderLayout.NORTH);

        // Description area with a vertical scrollbar for longer rooms
        roomDescriptionArea = new JTextArea();
        roomDescriptionArea.setEditable(false);
        roomDescriptionArea.setLineWrap(true);
        roomDescriptionArea.setWrapStyleWord(true);
        roomDescriptionArea.setFont(new Font("SansSerif", Font.PLAIN, 21));
        roomDescriptionArea.setForeground(NEON_PINK);
        roomDescriptionArea.setBackground(PANEL_GRAY);
        roomDescriptionArea.setMargin(new Insets(20, 22, 20, 22));
        roomDescriptionArea.setBorder(null);

        JScrollPane descriptionScroll = new JScrollPane(roomDescriptionArea);
        descriptionScroll.setBorder(null);
        descriptionScroll.setBackground(PANEL_GRAY);
        descriptionScroll.getViewport().setBackground(PANEL_GRAY);
        descriptionScroll.setHorizontalScrollBarPolicy(
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );
        descriptionScroll.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
        );
        descriptionScroll.getVerticalScrollBar().setUnitIncrement(16);
        leftPanel.add(descriptionScroll, BorderLayout.CENTER);

        // =====================================
        // RIGHT SIDE: COMMAND HISTORY AND INPUT
        // =====================================
        JPanel rightPanel = new JPanel(new BorderLayout(0, 0));
        rightPanel.setBackground(DARK_GRAY);

        messageArea = new JTextArea();
        messageArea.setEditable(false);
        messageArea.setLineWrap(true);
        messageArea.setWrapStyleWord(true);
        messageArea.setFont(new Font("Monospaced", Font.PLAIN, 19));
        messageArea.setForeground(MATRIX_GREEN);
        messageArea.setBackground(BLACK);
        messageArea.setMargin(new Insets(20, 20, 20, 20));

        JScrollPane messageScroll = new JScrollPane(messageArea);
        messageScroll.setBorder(null);
        messageScroll.getViewport().setBackground(BLACK);
        messageScroll.setHorizontalScrollBarPolicy(
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );
        rightPanel.add(messageScroll, BorderLayout.CENTER);

        // Command input section
        JPanel inputPanel = new JPanel(new BorderLayout(10, 10));
        inputPanel.setBackground(DARK_GRAY);
        inputPanel.setBorder(
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );

        JLabel promptLabel = new JLabel("Command:");
        promptLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        promptLabel.setForeground(WHITE);

        commandField = new JTextField();
        commandField.setFont(new Font("Monospaced", Font.PLAIN, 20));
        commandField.setForeground(MATRIX_GREEN);
        commandField.setBackground(DARK_GRAY);
        commandField.setCaretColor(MATRIX_GREEN);
        commandField.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 2, 0, MATRIX_GREEN),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
            )
        );

        inputPanel.add(promptLabel, BorderLayout.NORTH);
        inputPanel.add(commandField, BorderLayout.CENTER);
        rightPanel.add(inputPanel, BorderLayout.SOUTH);

        // =====================================
        // COMBINE THE LEFT AND RIGHT SIDES
        // =====================================
        JPanel bodyPanel = new JPanel(new GridLayout(1, 2, 0, 0));
        bodyPanel.setBackground(BLACK);
        // Keep the left column connected to the title banner; its silver
        // top border provides the separator instead of an extra black gap.
        bodyPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        bodyPanel.add(leftPanel);
        bodyPanel.add(rightPanel);

        add(bodyPanel, BorderLayout.CENTER);

        // Connect this interface to the existing Game class
        Game.setInterface(this);

        // Display the starting room
        refreshRoom();

        // Process a command when the player presses Enter
        commandField.addActionListener(e -> processInput());

        setVisible(true);
        SwingUtilities.invokeLater(() -> commandField.requestFocusInWindow());
    }

    // Makes a gray header with a centered label and a fixed height
    private JPanel makeHeaderPanel(JLabel label, int height) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(PANEL_GRAY);
        panel.add(label, BorderLayout.CENTER);
        panel.setPreferredSize(new Dimension(100, height));
        panel.setMinimumSize(new Dimension(0, height));
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, height));
        return panel;
    }

    private void styleHeading(JLabel heading, int size, Color color) {
        heading.setFont(new Font("SansSerif", Font.PLAIN, size));
        heading.setForeground(color);
    }

    // Update the room name and description after movement
    public void refreshRoom() {
        Room currentRoom = Game.getLocation();
        roomNameLabel.setText(currentRoom.getRname());

        String description = currentRoom.getRdesc(currentRoom.getRname());
        if (description == null) {
            roomDescriptionArea.setText("There is nothing to describe here.");
        } else {
            roomDescriptionArea.setText(description);
        }

        roomDescriptionArea.setCaretPosition(0);
    }

    // Display game messages in the Commands section
    public void showMessage(String message) {
        messageArea.append(message + "\n");
        messageArea.setCaretPosition(messageArea.getDocument().getLength());
    }

    // Send the player's command to the Game class
    private void processInput() {
        String command = commandField.getText().trim();
        if (command.isEmpty()) {
            return;
        }

        showMessage("> " + command);
        commandField.setText("");

        Game.runGameGUI(command);
        refreshRoom();

        if (command.equalsIgnoreCase("exit")) {
            dispose();
            return;
        }

        commandField.requestFocusInWindow();
    }

    // Launch the GUI
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Game.readRooms();
            new Interface();
        });
    }
}