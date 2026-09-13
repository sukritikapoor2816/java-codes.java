package assignment18;

import javax.swing.*;
import java.awt.event.*;

public class GUIcalculator {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Simple Calculator");

        JLabel l1 = new JLabel("First Number:");
        l1.setBounds(40, 30, 100, 30);

        JTextField t1 = new JTextField();
        t1.setBounds(150, 30, 150, 30);

        JLabel l2 = new JLabel("Second Number:");
        l2.setBounds(40, 70, 100, 30);

        JTextField t2 = new JTextField();
        t2.setBounds(150, 70, 150, 30);

        JButton add = new JButton("Add");
        add.setBounds(70, 120, 100, 35);

        JButton subtract = new JButton("Subtract");
        subtract.setBounds(180, 120, 100, 35);

        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int num1 = Integer.parseInt(t1.getText());
                int num2 = Integer.parseInt(t2.getText());

                int result = num1 + num2;

                JOptionPane.showMessageDialog(frame,
                    "Addition = " + result);
            }
        });

        subtract.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int num1 = Integer.parseInt(t1.getText());
                int num2 = Integer.parseInt(t2.getText());

                int result = num1 - num2;

                JOptionPane.showMessageDialog(frame,
                    "Subtraction = " + result);
            }
        });

        frame.add(l1);
        frame.add(t1);

        frame.add(l2);
        frame.add(t2);

        frame.add(add);
        frame.add(subtract);

        frame.setSize(350, 220);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}