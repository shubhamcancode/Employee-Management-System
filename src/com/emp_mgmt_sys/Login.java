package com.emp_mgmt_sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JTextField tf_username, tf_password;
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

//        username component
        JLabel lbl_username = new JLabel("Username ");
        lbl_username.setBounds(40, 20, 100, 30);
        add(lbl_username);

//      creating username text-fields
        tf_username = new JFormattedTextField();
        tf_username.setBounds(150, 20, 150, 30);
        add(tf_username);

//        password component
        JLabel lbl_password = new JLabel("Password ");
        lbl_password.setBounds(40, 70, 100, 30);
        add(lbl_password);

//        creating password text-field
        tf_password = new JFormattedTextField();
        tf_password.setBounds(150, 70, 150, 30);
        add(tf_password);

//        creating a login button
        JButton login = new JButton("LOGIN");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

//        adding a square-shaped image to the right side (200x200)
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);


        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            String username = tf_username.getText();
            String password = tf_password.getText();

            Conn c = new Conn();
//            Select is an DDL command so we are using executeQuery()
            String query = "select * from login where username = '"+username+"' and password = '"+password+"' ";
            ResultSet rs = c.s.executeQuery(query);

            if (rs.next()){
                setVisible(false);
//                next class : redirecting to Login Class : if -> valid username and password
                new Home();

            }else {
                JOptionPane.showMessageDialog(null, "Invalid username and password");
                setVisible(false);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }


}
