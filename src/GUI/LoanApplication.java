package GUI;

import User.UserInterface;
import View.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoanApplication implements ActionListener {

    private JFrame frame;
    private JPanel loanPanel;
    private JTextField amountTextField;
    private JTextField monthsTextField;
    private JTextField worthTextField;
    private JLabel loanAmount;
    private JLabel timeLabel;
    private JButton submitRequest;
    private JButton backButton;
    private UserInterface userInterface;

    public LoanApplication(UserInterface userInterface) {
        this.userInterface = userInterface;
        frame = View.getFrame();
        frame.getContentPane().setVisible(false);
        frame.getContentPane().repaint();
        frame.getContentPane().removeAll();
        frame.setContentPane(loanPanel);
        submitRequest.addActionListener(this);
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitRequest) {
            if (!amountTextField.getText().isEmpty() && verifyInput(amountTextField.getText()) && !worthTextField.getText().isEmpty() && verifyInput(worthTextField.getText()) && !monthsTextField.getText().isEmpty() && verifyInput(monthsTextField.getText())) {
                if (checkApproval()) {
                    System.out.println("Your specified loan was approved.");
                }
                else {
                    System.out.println("Your specified loan was not approved.");
                }
            }
        }
        else if(e.getSource() == backButton) {
            new accountsForm(userInterface);
        }

    }

    public boolean verifyInput(String s){
        return Double.parseDouble(s) > 0;
    }

    public boolean checkApproval() {
        if (Double.parseDouble(worthTextField.getText()) *  Double.parseDouble(monthsTextField.getText()) / 50.0 >  Double.parseDouble(amountTextField.getText())) {
            return true;
        }
        else {
            return false;
        }
    }
}
