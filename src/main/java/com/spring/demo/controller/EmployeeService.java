package com.spring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akhil on 3/4/17.
 */

@Service
public class EmployeeService {

    EmployeeDAO employeeDAO;

    public EmployeeDAO getEmployeeDAO() {
        return employeeDAO;
    }

    @Autowired
    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    boolean addManagerToDbService(String Managername){
        Managername=Managername.toLowerCase();
        boolean success=employeeDAO.updateDBWithManager(Managername);
        System.out.println(success);
        if(success)
            return true;
        else
            return false;
    }


    public List getManagersService() {
        List managersList = new ArrayList();
       managersList =  employeeDAO.getManagersList();
        return managersList;

    }


    boolean addEmployee(String employeename, String managerName){
        employeename=employeename.toLowerCase();
        boolean success=employeeDAO.updateDBWithEmployee(employeename,managerName);
        if(success)
            return true;
        else
            return false;
    }


    public List getEmployeeService(String managername){
        List employeeList= new ArrayList();
        employeeList=employeeDAO.getEmployeeList(managername);
        return employeeList;
    }
}
