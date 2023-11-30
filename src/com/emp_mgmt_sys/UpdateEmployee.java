package com.emp_mgmt_sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateEmployee extends JFrame implements ActionListener {

    JTextField tf_education, tf_fname, tf_salary, tf_address, tf_phone, tf_email, tf_designation;
    JLabel lbl_empID;
    JButton add, back;
    String empID;

    //    Constructor :
    UpdateEmployee(String empID){

        this.empID = empID;
//        making changes in frame color
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

//        title : Add Employee Details
        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

//        Name :
        JLabel labelname = new JLabel("Name ");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(labelname);
//        Name - TextField
        JLabel lbl_name = new JLabel();
        lbl_name.setBounds(200, 150, 150, 30);
        add(lbl_name);


//       Father Name :
        JLabel labelfname = new JLabel("Father's Name ");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(labelfname);
//        Name - TextField
        tf_fname = new JTextField();
        tf_fname.setBounds(600, 150, 150, 30);
        add(tf_fname);

        //       DOB :
        JLabel labeldob = new JLabel("DOB ");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(labeldob);
//        DOB : Date component
        JLabel lbl_dob = new JLabel();
        lbl_dob.setBounds(200, 200, 150, 30);
        add(lbl_dob);

//        Salary :
        JLabel labelsalary = new JLabel("Salary ");
        labelsalary.setBounds(400, 200, 150, 30);
        labelsalary.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(labelsalary);
//        Salary - TextField
        tf_salary = new JTextField();
        tf_salary.setBounds(600, 200, 150, 30);
        add(tf_salary);

//        Address :
        JLabel labeladdress = new JLabel("Address ");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(labeladdress);
//        Address - TextField
        tf_address = new JTextField();
        tf_address.setBounds(200, 250, 150, 30);
        add(tf_address);

//       Phone Number :
        JLabel labelphone = new JLabel("Phone ");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(labelphone);
//        Phone - TextField
        tf_phone = new JTextField();
        tf_phone.setBounds(600, 250, 150, 30);
        add(tf_phone);

//       Email  :
        JLabel labelemail = new JLabel("Email ");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(labelemail);
//        Email - TextField
        tf_email = new JTextField();
        tf_email.setBounds(200, 300, 150, 30);
        add(tf_email);

//       Highest Education :
        JLabel labelhighesteducation = new JLabel("Education ");
        labelhighesteducation.setBounds(400, 300, 150, 30);
        labelhighesteducation.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(labelhighesteducation);
//        Highest Education - Dropdown
        tf_education = new JTextField();
        tf_education.setBackground(Color.WHITE);
        tf_education.setBounds(600, 300, 150, 30);
        add(tf_education);

//        Designation :
        JLabel labeldesignation = new JLabel("Designation ");
        labeldesignation.setBounds(50, 350, 150, 30);
        labeldesignation.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(labeldesignation);
//        Designation - TextField
        tf_designation = new JTextField();
        tf_designation.setBounds(200, 350, 150, 30);
        add(tf_designation);


//      Aadhar Number :
        JLabel labelaadhar = new JLabel("Aadhar Number ");
        labelaadhar.setBounds(400, 350, 150, 30);
        labelaadhar.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(labelaadhar);
//      Aadhar Number - TextField
        JLabel lbl_aadhar = new JLabel();
        lbl_aadhar.setBounds(600, 350, 150, 30);
        add(lbl_aadhar);

//        EmployeeID :
        JLabel labelempid = new JLabel("Employee ID ");
        labelempid.setBounds(50, 400, 150, 30);
        labelempid.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(labelempid);

//        EmployeeID: Unchanged/Fixed
        lbl_empID = new JLabel();
        lbl_empID.setBounds(200, 400, 150, 30);
        lbl_empID.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lbl_empID);

        try {
            Conn c = new Conn();
            String query = "select * from employee where empID = '"+empID+"' ";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()){
                lbl_name.setText(rs.getString("name"));
                tf_fname.setText(rs.getString("fname"));
                lbl_dob.setText(rs.getString("dob"));
                tf_salary.setText(rs.getString("salary"));
                tf_address.setText(rs.getString("address"));
                tf_phone.setText(rs.getString("phone"));
                tf_email.setText(rs.getString("email"));
                tf_education.setText(rs.getString("education"));
                tf_designation.setText(rs.getString("designation"));
                lbl_aadhar.setText(rs.getString("aadhar"));
                lbl_empID.setText(rs.getString("empID"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }

//        Add Details buttons :
        add = new JButton("Update Employee ");
        add.setBounds(250, 500, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);

//        Back buttons :
        back = new JButton("Back ");
        back.setBounds(450, 500, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add){
            String fname = tf_fname.getText();
            String salary = tf_salary.getText();
            String address = tf_address.getText();
            String phone = tf_phone.getText();
            String email = tf_email.getText();
            String education = tf_education.getText();
            String designation = tf_designation.getText();

//            as db is an external entity, high chances of getting an error
            try {
                Conn conn = new Conn();
                String query = "update employee set fname = '"+fname+"', salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"', education = '"+education+"', designation = '"+designation+"' where empID = '"+empID+"' ";
//          Insert is an DML command
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
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
        new UpdateEmployee("");
    }


}
