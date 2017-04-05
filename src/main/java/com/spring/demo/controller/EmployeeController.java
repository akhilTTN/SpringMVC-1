package com.spring.demo.controller;

import com.spring.demo.controller.co.EmployeeCO;
import com.spring.demo.controller.co.ManagerCo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by akhil on 3/4/17.
 */
@Controller
public class EmployeeController {

    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    ModelAndView showHtml() {
        return new ModelAndView("manager");
    }

    @RequestMapping(value = "/addManager", method = RequestMethod.POST)
    ModelAndView addManager(ManagerCo managerCo) {
        ModelAndView modelAndView = new ModelAndView("manager");
        String Managername = managerCo.getManager_name();
        boolean success = employeeService.addManagerToDbService(Managername);
        System.out.println(success);
        if (success)
            modelAndView.addObject("msg", "Manager inserted successfuly");
        else
            modelAndView.addObject("msg", "Manager not inserted   ");
        return modelAndView;
    }

    @RequestMapping(value = "/shows", method = RequestMethod.POST)
    ModelAndView showManagers(){
        ModelAndView modelAndView = new ModelAndView("showManagers");
        List managers = employeeService.getManagersService();
        System.out.println(managers.toString());
        modelAndView.addObject("managers", managers);
        return modelAndView;

    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    ModelAndView addEmployee(EmployeeCO employeeCO){
        ModelAndView modelAndView=new ModelAndView("/showManagers");
        String employeeName= employeeCO.getEmployeeName();
        String managerName= employeeCO.getManagerName();
        boolean success = employeeService.addEmployee(employeeName,managerName);
        if (success)
            modelAndView.addObject("msg1", "Employee inserted successfuly");
        else
            modelAndView.addObject("msg1", "Employee not inserted   ");
        return modelAndView;
    }



    @RequestMapping(value = "/showEmployee", method = RequestMethod.POST)
    ModelAndView showEmployee(EmployeeCO employeeCO){
        ModelAndView modelAndView= new ModelAndView("showEmployee");
        List employees=new ArrayList();
        employees=employeeService.getEmployeeService(employeeCO.getManagerName());
        System.out.println(employees);
        modelAndView.addObject("employees",employees);
        return modelAndView;
    }
}
