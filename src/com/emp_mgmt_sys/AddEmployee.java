package com.emp_mgmt_sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import com.toedter.calendar.JDateChooser;

public class AddEmployee extends JFrame implements ActionListener {
    Random ran = new Random();
    int number = ran.nextInt(999999);

    JTextField tf_name, tf_fname, tf_salary, tf_address, tf_phone, tf_email, tf_designation, tf_aadhar;
    JDateChooser dcdob;
    JComboBox cb_education;
    JLabel lblempId;
    JButton add, back;

//    Constructor :
    AddEmployee(){
//        making changes in frame color
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

//        title : Add Employee Details
        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

//        Name :
        JLabel labelname = new JLabel("Name ");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(labelname);
//        Name - TextField
        tf_name = new JTextField();
        tf_name.setBounds(200, 150, 150, 30);
        add(tf_name);


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
        dcdob = new JDateChooser();
        dcdob.setBounds(200, 200, 150, 30);
        add(dcdob);

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
        String[] courses = {"BBA", "BCA", "BSC", "BE", "BTech", "BA", "BCOM", "MTech", "MCA", "MSC", "ME", "MA", "MCOM"};
        cb_education = new JComboBox(courses);
        cb_education.setBackground(Color.WHITE);
        cb_education.setBounds(600, 300, 150, 30);
        add(cb_education);

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
        tf_aadhar = new JTextField();
        tf_aadhar.setBounds(600, 350, 150, 30);
        add(tf_aadhar);

//        EmployeeID :
        JLabel labelempid = new JLabel("Employee ID ");
        labelempid.setBounds(50, 400, 150, 30);
        labelempid.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(labelempid);

//        EmployeeID: Unchanged/Fixed
        lblempId = new JLabel("" + number);
        lblempId.setBounds(200, 400, 150, 30);
        lblempId.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lblempId);

//        Add Details buttons :
        add = new JButton("Add Employee ");
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
            String name = tf_name.getText();
            String fname = tf_fname.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tf_salary.getText();
            String address = tf_address.getText();
            String phone = tf_phone.getText();
            String email = tf_email.getText();
            String education = (String) cb_education.getSelectedItem();
            String designation = tf_designation.getText();
            String aadhar = tf_aadhar.getText();
            String empID = lblempId.getText();

//            as db is an external entity, high chances of getting an error
            try {
                Conn conn = new Conn();
                String query = "insert into employee values('"+name+"', '"+fname+"', '"+dob+"', '"+salary+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+designation+"', '"+aadhar+"', '"+empID+"')";
//          Insert is an DML command
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Added Successfully");
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
        new ViewEmployee();
    }


}
