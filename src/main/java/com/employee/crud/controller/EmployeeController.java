package com.employee.crud.controller;

import com.employee.crud.entity.Employee;
import com.employee.crud.exception.BusinessException;
import com.employee.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public ResponseEntity getAllEmployees() {
        System.out.println("进入了get方法");
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody Employee employee) {
        System.out.println("进入了add方法");
        employeeService.addemployee(employee);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/update/{Id}")
    public ResponseEntity updateUserById(@PathVariable int Id, @RequestBody Employee employee) throws BusinessException {
        System.out.println("进入了update方法");
        employeeService.updateEmployeeById(Id, employee);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/{Id}")
    public ResponseEntity deleteUserById(@PathVariable int Id) throws BusinessException {
        System.out.println("进入了delete方法");
        employeeService.deleteEmployeeById(Id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
