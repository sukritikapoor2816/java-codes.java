package assignment17;

import javax.swing.*;
import java.awt.event.*;

public class StudentRegistration {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Student Registration Form");

        JLabel l1 = new JLabel("Student ID:");
        l1.setBounds(40, 30, 100, 30);

        JTextField t1 = new JTextField();
        t1.setBounds(150, 30, 150, 30);

        JLabel l2 = new JLabel("Name:");
        l2.setBounds(40, 70, 100, 30);

        JTextField t2 = new JTextField();
        t2.setBounds(150, 70, 150, 30);

        JLabel l3 = new JLabel("Course:");
        l3.setBounds(40, 110, 100, 30);

        JTextField t3 = new JTextField();
        t3.setBounds(150, 110, 150, 30);

        JLabel l4 = new JLabel("Email:");
        l4.setBounds(40, 150, 100, 30);

        JTextField t4 = new JTextField();
        t4.setBounds(150, 150, 150, 30);

        JButton button = new JButton("Register");
        button.setBounds(120, 195, 120, 35);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(frame,
                    "Student ID: " + t1.getText() +
                    "\nName: " + t2.getText() +
                    "\nCourse: " + t3.getText() +
                    "\nEmail: " + t4.getText());
            }
        });

        frame.add(l1);
        frame.add(t1);

        frame.add(l2);
        frame.add(t2);

        frame.add(l3);
        frame.add(t3);

        frame.add(l4);
        frame.add(t4);

        frame.add(button);

        frame.setSize(350, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}