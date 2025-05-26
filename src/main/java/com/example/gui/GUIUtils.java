package com.example.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * GUIUtils.java
 * A utility class for creating and managing GUI components.
 */
public class GUIUtils {

    /**
     * Creates a JButton with the given text and action listener.
     *
     * @param text     The text to display on the button.
     * @param listener The action listener for the button.
     * @return A configured JButton instance.
     */
    public static JButton createButton(String text, ActionListener listener) {
        JButton button = new JButton(text);
        button.addActionListener(listener);
        button.setPreferredSize(new Dimension(120, 30));
        return button;
    }

    /**
     * Creates a JLabel with the given text and font size.
     *
     * @param text     The text to display on the label.
     * @param fontSize The size of the font.
     * @return A configured JLabel instance.
     */
    public static JLabel createLabel(String text, int fontSize) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, fontSize));
        return label;
    }

    /**
     * Creates a JTextField with a preferred width.
     *
     * @param columns The number of columns for the text field.
     * @return A configured JTextField instance.
     */
    public static JTextField createTextField(int columns) {
        JTextField textField = new JTextField(columns);
        return textField;
    }

    /**
     * Creates a JTextArea with a preferred size and scroll functionality.
     *
     * @param rows    The number of rows for the text area.
     * @param columns The number of columns for the text area.
     * @return A configured JTextArea instance with a JScrollPane.
     */
    public static JScrollPane createTextAreaWithScroll(int rows, int columns) {
        JTextArea textArea = new JTextArea(rows, columns);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        return new JScrollPane(textArea);
    }

    /**
     * Displays an information message dialog.
     *
     * @param parent  The parent component.
     * @param message The message to display.
     * @param title   The title of the dialog.
     */
    public static void showInfoDialog(Component parent, String message, String title) {
        JOptionPane.showMessageDialog(parent, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Displays an error message dialog.
     *
     * @param parent  The parent component.
     * @param message The error message to display.
     * @param title   The title of the dialog.
     */
    public static void showErrorDialog(Component parent, String message, String title) {
        JOptionPane.showMessageDialog(parent, message, title, JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Creates a JPanel with a GridBagLayout and default padding.
     *
     * @return A JPanel with GridBagLayout.
     */
    public static JPanel createFormPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return panel;
    }

    /**
     * Adds a component to a panel with GridBagLayout constraints.
     *
     * @param panel      The panel to which the component will be added.
     * @param component  The component to add.
     * @param gridx      The grid x position.
     * @param gridy      The grid y position.
     * @param gridwidth  The number of cells the component occupies horizontally.
     * @param anchor     The anchor position (e.g., GridBagConstraints.WEST).
     */
    public static void addToPanel(JPanel panel, Component component, int gridx, int gridy, int gridwidth, int anchor) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridwidth;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = anchor;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(component, gbc);
    }

    /**
     * Centers a JFrame on the screen.
     *
     * @param frame The JFrame to center.
     */
    public static void centerFrame(JFrame frame) {
        frame.setLocationRelativeTo(null);
    }

    /**
     * Creates a simple header label with bold font and larger size.
     *
     * @param text The text for the header.
     * @return A JLabel styled as a header.
     */
    public static JLabel createHeaderLabel(String text) {
        JLabel headerLabel = new JLabel(text, SwingConstants.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        return headerLabel;
    }

    /**
     * Adds spacing between components by adding an empty JPanel.
     *
     * @param panel The panel to which spacing will be added.
     * @param gridy The y-coordinate for the spacing.
     */
    public static void addVerticalSpacing(JPanel panel, int gridy) {
        JPanel spacer = new JPanel();
        spacer.setPreferredSize(new Dimension(0, 10));
        addToPanel(panel, spacer, 0, gridy, 2, GridBagConstraints.CENTER);
    }
}
