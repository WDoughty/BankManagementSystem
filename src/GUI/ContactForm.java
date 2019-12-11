package GUI;

import Database.Database;
import View.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm implements ActionListener{

    private Database db;
    private JFrame frame;
    private JPanel ContactForm;
    private JButton backButton;
    private JButton submitButton;
    private JTextField subjectTextField;
    private JTextField emailTextField;
    private JTextArea bodyTextArea;

    /**
     * Creates a new Contact Form
     */
    public ContactForm() {
        db = new Database();
        frame = View.getFrame();
        frame.getContentPane().setVisible(false);
        frame.getContentPane().repaint();
        frame.getContentPane().removeAll();
        frame.setContentPane(ContactForm);
        backButton.addActionListener(this);
        submitButton.addActionListener(this);
    }

    /**
     * Action Listener
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            if (!subjectTextField.getText().isEmpty() && !emailTextField.getText().isEmpty() && !bodyTextArea.getText().isEmpty() && verifyEmail(emailTextField.getText())) {
                if (db.putContact(subjectTextField.getText(), emailTextField.getText(), bodyTextArea.getText())) {
                    JOptionPane.showMessageDialog(frame, "Message received and awaiting response from representative", "Contact Successful", JOptionPane.PLAIN_MESSAGE);
                    new CustomerSupportForm();
                } else {
                    JOptionPane.showMessageDialog(frame, "Failed to contact customer support", "Contact Failed", JOptionPane.WARNING_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(frame, "Improper Inputs", "Improper Inputs", JOptionPane.WARNING_MESSAGE);
            }
        }
        else if (e.getSource() == backButton) {
            new CustomerSupportForm();
        }
    }

    /**
     * Verifies that the email ends in .com and contains an '@' but does not start with one
     * @param s
     * @return
     */
    public boolean verifyEmail(String s) {
        if (s.length() >= 7) {
            if (s.substring(s.length() - 4).equals(".com") && !s.substring(0, 1).equals("@") && s.contains("@")) {
                return true;
            }
        }
        return false;
    }

}
