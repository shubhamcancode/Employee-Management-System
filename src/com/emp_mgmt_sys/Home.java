package com.emp_mgmt_sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {
    JButton add, view, update, remove;
    public Home(){
        setLayout(null);

//        image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 620, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(620, 20, 400 ,40);
//        want to add heading over the image component
        heading.setFont(new Font("Rale way", Font.BOLD, 25));
        image.add(heading);

//        Add buttons :
        add = new JButton("Add Employee ");
        add.setBounds(650, 80, 150, 40);
        add.addActionListener(this);
        image.add(add);

//        View Button :
        view = new JButton("View Employees ");
        view.setBounds(820, 80, 150, 40);
        view.addActionListener(this);
        image.add(view);

//        Update button :
        update = new JButton("Update Employee ");
        update.setBounds(820, 150, 150, 40);
        update.addActionListener(this);
        image.add(update);

//        Delete button :
        remove = new JButton("Remove Employee ");
        remove.setBounds(650, 150, 150, 40);
        remove.addActionListener(this);
        image.add(remove);



//        after adding buttons, we have to add events by implementing ActionListener

        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);

    }

//    creating events for buttons
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == add){
            setVisible(false);
            new AddEmployee();
        } else if (ae.getSource() == view) {
            setVisible(false);
            new ViewEmployee();
        } else if (ae.getSource() == update) {
            setVisible(false);
            new ViewEmployee();
        } else {
            setVisible(false);
            new RemoveEmployee();
        }
    }

    public static void main(String[] args) {
        new Home();
    }

}
