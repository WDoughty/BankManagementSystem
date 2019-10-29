package View;

import javax.swing.*;
import java.awt.*;

public class View {

    public static void main(String args[]){
        JOptionPane jo = new JOptionPane();
        jo.setSize(500,500);
        String operationNumber= jo.showInputDialog("Enter operation number \n"+" " +
                "1. Add Student\n"+" 2. Add Grade\n"+" 3. Get Average Grade");
        int code = Integer.parseInt(operationNumber);

    }
}
