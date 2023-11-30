package com.emp_mgmt_sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener {
//    as I want a frame at the start of the pgm, I will put everything in the ctor
    Splash(){
//        for adding color to the frame
        getContentPane().setBackground(Color.WHITE);
//        I don't want to go with the default swing layout's
        setLayout(null);
//        Component - Title of the Project
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM ");
//        creating custom layout
        heading.setBounds(80, 30, 1200, 60);
        heading.setFont(new Font("serif", Font.PLAIN, 60));
        heading.setForeground(Color.RED);

        add(heading);
//        foreground image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 100, 1050, 500);
        add(image);

//        creating a continue button
        JButton clickhere = new JButton("Click here to Continue");
        clickhere.setBounds(400, 400, 300, 70);
        clickhere.setBackground(Color.BLACK);
        clickhere.setForeground(Color.WHITE);
        clickhere.addActionListener(this);
        image.add(clickhere);


//        Main-Frame size
        setSize(1170, 650);
        setLocation(200, 50);
        setVisible(true);

//        Creating a dipper animation on the title
        while (true){
            heading.setVisible(false);
            try {
                Thread.sleep(500);
            }catch (Exception e){

            }

            heading.setVisible(true);
            try {
                Thread.sleep(500);
            }catch (Exception e){

            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
//        this will close current frame
        setVisible(false);
//        to open login frame, we have to create obj of Login class
        new Login();

    }

    public static void main(String[] args) {
//        we are creating an anonymous object,
//        as we create an obj, ctor will get called, here default ctor is called
//        we are going to perform all the activities in the default ctor
        new Splash();
    }

}
