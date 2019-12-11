package GUI;

import View.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerSupportForm implements ActionListener{

    private JFrame frame;
    private JPanel SupportForm;
    private JButton contactButton;
    private JButton appointmentButton;
    private JButton backButton;

    /**
     * Creates a new Customer Support Form
     */
    public CustomerSupportForm() {
        frame = View.getFrame();
        frame.getContentPane().setVisible(false);
        frame.getContentPane().repaint();
        frame.getContentPane().removeAll();
        frame.setContentPane(SupportForm);
        contactButton.addActionListener(this);
        appointmentButton.addActionListener(this);
        backButton.addActionListener(this);
    }

    /**
     * Action Listener
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == contactButton) {
            new ContactForm();
        }
        else if (e.getSource() == appointmentButton) {
            new AppointmentForm();
        }
        else if (e.getSource() == backButton) {
            new LoginForm();
        }
    }
}
