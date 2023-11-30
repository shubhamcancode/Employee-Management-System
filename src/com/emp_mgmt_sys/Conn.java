package com.emp_mgmt_sys;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class Conn {
//    2.Creating the connection String
    Connection c;
//    3.Creating statement
    Statement s;
    public Conn(){
        try {
//            1.Register the Driver Class
            Class.forName("com.mysql.cj.jdbc.Driver");
//            Step 2
            c = DriverManager.getConnection("jdbc:mysql:///employee_management_system", "root","root");
//            Step 3
            s = c.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
