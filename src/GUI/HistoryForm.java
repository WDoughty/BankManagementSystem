package GUI;

import User.UserController;
import User.UserInterface;
import View.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Database.Database;

public class HistoryForm implements ActionListener {
    private JFrame frame;
    private JPanel historyPanel;
    private JTextArea statementArea;
    private JButton backButton;
    private UserInterface userInterface;
    private Database db;
    private UserController userController;

    public HistoryForm(UserInterface userInterface) {
        db = new Database();
        this.userInterface = userInterface;
        userController = new UserController(userInterface);
        frame = View.getFrame();
        frame.getContentPane().setVisible(false);
        frame.getContentPane().repaint();
        frame.getContentPane().removeAll();
        frame.setContentPane(historyPanel);
        backButton.addActionListener(this);
        statementArea.setEditable(false);
        statementArea.append(db.getTransactions(userController.getUserAccountNumber()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton) {
            new accountsForm(userInterface);
        }
    }
}
