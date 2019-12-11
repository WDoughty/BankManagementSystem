package GUI;

import Database.Database;
import View.View;

import javax.persistence.criteria.CriteriaBuilder;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppointmentForm implements ActionListener{

    private Database db;
    private JFrame frame;
    private JPanel AppointmentForm;
    private JButton backButton;
    private JTextField nameTextField;
    private JTextField timeTextField;
    private JButton submitButton;
    private JTextField dateTextField;

    /**
     * Creates a new Appointment Form
     */
    public AppointmentForm() {
        db = new Database();
        frame = View.getFrame();
        frame.getContentPane().setVisible(false);
        frame.getContentPane().repaint();
        frame.getContentPane().removeAll();
        frame.setContentPane(AppointmentForm);
        submitButton.addActionListener(this);
        backButton.addActionListener(this);

    }

    /**
     * Action Listener
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            if (!nameTextField.getText().isEmpty() && !timeTextField.getText().isEmpty() && !dateTextField.getText().isEmpty() && verifyTime(timeTextField.getText()) && verifyDate(dateTextField.getText())) {
                if (db.putAppointment(nameTextField.getText(), timeTextField.getText(), dateTextField.getText())) {
                    JOptionPane.showMessageDialog(frame, "Appointment successfully created at the desired time and date", "Appointment Creation Successful", JOptionPane.PLAIN_MESSAGE);
                    new CustomerSupportForm();
                } else {
                    JOptionPane.showMessageDialog(frame, "Selected time and date are already taken.", "Appointment Creation Failed", JOptionPane.WARNING_MESSAGE);
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
     * Verifies that the time is from 9 to 4
     * @param s
     * @return
     */
    public boolean verifyTime(String s) {
        int temp = Integer.parseInt(s);
        if (temp >= 1 && temp <= 4 || temp >= 9 && temp <= 12) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Verifies that the date is in the valid formatting and 2019 to 2021
     * @param s
     * @return
     */
    public boolean verifyDate(String s) {
        String[] temp = s.split("/");
        if (temp.length == 3) {
            int m = Integer.parseInt(temp[0]);
            int d = Integer.parseInt(temp[1]);
            int y = Integer.parseInt(temp[2]);
            if (m >= 1 && m <= 12 && d >= 1 && d <= 31 && y >= 2019 && y <= 2021) {
                return true;
            }
        }
        return false;
    }
}
