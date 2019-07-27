package com.employee.crud.service;

import com.employee.crud.data.EmployeeData;
import com.employee.crud.entity.Employee;
import com.employee.crud.exception.BusinessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> employeeData = EmployeeData.employeeData();

    public List<Employee> getAllEmployees() {
        return employeeData;
    }

    public void addemployee(Employee employee) {

        employeeData.add(employee);
    }

    public void updateEmployeeById(int id, Employee employee) throws BusinessException {
        Employee employeeInfo = getEmployeeById(id);
        employeeInfo.setName(employee.getName());
        save(employeeInfo);
    }

    public void deleteEmployeeById(int userId) throws BusinessException {
        deleteById(userId);
    }

    private Employee getEmployeeById(int id) throws BusinessException {
        return employeeData.stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElseThrow(() -> new BusinessException(
                        String.format("Unknown User with id: %s", id)
                ));
    }

    private void save(Employee employeeInfo) {
        int index = 0;
        for(int i = 0; i<employeeData.size(); i++){
            if(employeeData.get(i).getId() == employeeInfo.getId()){
                index = i;
            }
        }
        employeeData.set(index, employeeInfo);
    }

    private void deleteById(int userId) throws BusinessException {
        Employee user = getEmployeeById(userId);
        employeeData.remove(user);
    }
}
