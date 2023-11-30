package com.emp_mgmt_sys;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewEmployee extends JFrame implements ActionListener {


    JTable table;
//    creating drop-down
    Choice c_employeeID;
//    Buttons : Global Declaration
    JButton search, print, update, back;

//    constructor
    ViewEmployee(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

//        for searching an employee
        JLabel searchlbl = new JLabel("Search by Employee ID");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);

//        employee_ID drop-down
        c_employeeID = new Choice();
        c_employeeID.setBounds(180, 20, 150, 20);
        add(c_employeeID);


//        Dynamically inserting empID
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while (rs.next()){
                c_employeeID.add(rs.getString("empID"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        table = new JTable();

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
//            to create a table we've used : js2XML.jar file
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e){
            e.printStackTrace();
        }

//        adding scroll bar
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);

//        Search Button :
        search = new JButton("Search ");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);

//        Print button :
        print = new JButton("Print ");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);

//        Update button :
        update = new JButton("Update ");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);

//        Back button :
        back = new JButton("Back ");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);

        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search){
            String query = "select * from employee where empID = '"+c_employeeID.getSelectedItem()+"' ";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e){
                e.printStackTrace();

            }


        } else if (ae.getSource() == print) {
            try {
                table.print();
            }catch (Exception e){
                e.printStackTrace();
            }

        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateEmployee(c_employeeID.getSelectedItem());
        } else {
            setVisible(false);
            new Home();
        }
    }
    public static void main(String[] args) {
        new ViewEmployee();
    }

}
