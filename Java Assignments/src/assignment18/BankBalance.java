package assignment18;

import javax.swing.*;
import java.awt.event.*;

public class BankBalance {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Bank Balance Calculator");

        JLabel l1 = new JLabel("Initial Balance:");
        l1.setBounds(40, 30, 120, 30);

        JTextField t1 = new JTextField();
        t1.setBounds(160, 30, 150, 30);

        JLabel l2 = new JLabel("Transaction Amount:");
        l2.setBounds(40, 70, 120, 30);

        JTextField t2 = new JTextField();
        t2.setBounds(160, 70, 150, 30);

        JButton deposit = new JButton("Deposit");
        deposit.setBounds(70, 120, 100, 35);

        JButton withdraw = new JButton("Withdraw");
        withdraw.setBounds(180, 120, 100, 35);

        deposit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                double balance = Double.parseDouble(t1.getText());
                double amount = Double.parseDouble(t2.getText());

                balance = balance + amount;

                JOptionPane.showMessageDialog(frame,
                    "Updated Balance = " + balance);
            }
        });

        withdraw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                double balance = Double.parseDouble(t1.getText());
                double amount = Double.parseDouble(t2.getText());

                balance = balance - amount;

                JOptionPane.showMessageDialog(frame,
                    "Updated Balance = " + balance);
            }
        });

        frame.add(l1);
        frame.add(t1);

        frame.add(l2);
        frame.add(t2);

        frame.add(deposit);
        frame.add(withdraw);

        frame.setSize(350, 220);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}