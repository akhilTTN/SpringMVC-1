package com.spring.demo.controller;

import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by akhil on 3/4/17.
 */

@Service
public class EmployeeDAO {

    private String conString = "jdbc:mysql://localhost:3306/servletdb";

    boolean updateDBWithManager(String Managername) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(conString, "root", "root");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("insert into managers(name) values('" + Managername + "')");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    List getManagersList() {
        List managerList = new ArrayList();
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(conString, "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from managers");
            while (rs.next()) {

                managerList.add(rs.getString("id"));
                managerList.add(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
//            return false;
        }
        return managerList;
    }


    boolean updateDBWithEmployee(String employeename, String managerName){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(conString, "root", "root");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("insert into employee(Ename,Mname) values('" +employeename+",'"+ managerName + "')");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    List getEmployeeList(String Managername){
        List employeeList= new ArrayList();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(conString, "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from employee where Mname ='"+Managername+"';");
            while (rs.next()) {

                employeeList.add(rs.getString("id"));
                employeeList.add(rs.getString("Mname"));
                employeeList.add(rs.getString("Ename"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}
