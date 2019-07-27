package com.employee.crud.data;

import com.employee.crud.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeData {
    public static List<Employee> employeeData() {
        List<Employee> employeList = new ArrayList<>();
        Employee employee1 = new Employee(0, "小明",20,"男");
        Employee employee2 = new Employee(1, "小红",19,"女");
        Employee employee3 = new Employee(2, "小智",15,"男");
        Employee employee4 = new Employee(3, "小刚",16,"男");
        Employee employee5 = new Employee(4, "小夏",15,"女");
        employeList.add(employee1);
        employeList.add(employee2);
        employeList.add(employee3);
        employeList.add(employee4);
        employeList.add(employee5);
        return employeList;
    }
}
