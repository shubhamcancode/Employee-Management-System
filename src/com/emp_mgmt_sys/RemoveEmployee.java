package com.emp_mgmt_sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class RemoveEmployee extends JFrame implements ActionListener {
    Choice c_empID;
    JButton delete, back;

    RemoveEmployee(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel label_empID = new JLabel("Employee ID ");
        label_empID.setBounds(50, 50, 100, 30);
        add(label_empID);
        c_empID = new Choice();
        c_empID.setBounds(200, 50, 150, 30);
        c_empID.setBackground(Color.WHITE);
        add(c_empID);

        try {
            Conn c = new Conn();
            String query = "select * from employee";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()){
                c_empID.add(rs.getString("empID"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

//        Name :
        JLabel label_name = new JLabel("Name ");
        label_name.setBounds(50, 100, 100, 30);
        add(label_name);

        JLabel lbl_name = new JLabel();
        lbl_name.setBounds(200, 100, 100, 30);
        add(lbl_name);

//        Phone :
        JLabel label_phone = new JLabel("Phone ");
        label_phone.setBounds(50, 150, 100, 30);
        add(label_phone);

        JLabel lbl_phone = new JLabel();
        lbl_phone.setBounds(200, 150, 100, 30);
        add(lbl_phone);

//        Email
        JLabel label_email = new JLabel("Email ");
        label_email.setBounds(50, 200, 100, 30);
        add(label_email);

        JLabel lbl_email = new JLabel();
        lbl_email.setBounds(200, 200, 150, 30);
        add(lbl_email);

        try {
            Conn c = new Conn();
            String query = "select * from employee where empID = '"+c_empID.getSelectedItem()+"' ";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()){
                lbl_name.setText(rs.getString("name"));
                lbl_phone.setText(rs.getString("phone"));
                lbl_email.setText(rs.getString("email"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        c_empID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    Conn c = new Conn();
                    String query = "select * from employee where empID = '"+c_empID.getSelectedItem()+"' ";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()){
                        lbl_name.setText(rs.getString("name"));
                        lbl_phone.setText(rs.getString("phone"));
                        lbl_email.setText(rs.getString("email"));
                    }
                }catch (Exception ee){
                    ee.printStackTrace();
                }
            }
        });

//        Delete Button :
        delete = new JButton("Delete ");
        delete.setBounds(80, 300, 100, 30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

//        Back Button :
        back = new JButton("Back ");
        back.setBounds(220, 300, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

//      Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, -5, 600, 400);
        add(image);

        setSize(1000, 400);
        setLocation(300, 150);
        setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent ae) {
//        Event Handling
        if (ae.getSource() == delete){

            try {
                Conn c = new Conn();
                String query = "delete from employee where empID = '"+c_empID.getSelectedItem()+"' ";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Information Deleted Successfully");
                setVisible(false);
                new Home();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
            new Home();
        }

    }


    public static void main(String[] args) {
        new RemoveEmployee();
    }



}
