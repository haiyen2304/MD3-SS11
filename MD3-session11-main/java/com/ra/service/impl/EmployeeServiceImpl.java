package com.ra.service.impl;

import com.ra.dto.EmployeeRequest;
import com.ra.model.Employee;
import com.ra.service.IEmployeeService;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmployeeServiceImpl implements IEmployeeService {
    private static final String uploadsPath = "C:\\Users\\Administrator\\IdeaProjects\\JDBC\\Employee\\src\\main\\webapp\\uploads";
    private static final List<Employee> employees = new ArrayList<>();
    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public Employee findById(Integer id) {
        return employees.stream().filter(employee -> Objects.equals(employee.getId(), id)).findFirst().orElse(null);
    }

    @Override
    public void save(EmployeeRequest request) throws IOException {
        if(request.getId() != null){
            //cap nhat
            Employee employee = findById(request.getId());
            if(!request.getName().isEmpty()){
                employee.setName(request.getName());
            }
            employee.setSex(request.getSex());
            employee.setBirthDay(request.getBirthDay());
            employee.setAddress(request.getAddress());
            Part file = request.getImage();
            if(file != null && file.getSize()!=0){
                //upload
                employee.setImage("/uploads/"+file.getSubmittedFileName());
                file.write(uploadsPath + File.separator + file.getSubmittedFileName());
            }
            employees.set(employees.indexOf(employee), employee);
        }else{
            // them moi
            //chuyen tu dto -> model
            //upload file
            Employee newEmployee = new Employee(getNewId(),request.getName(),"https:i.pinimg.com/736x/bc/43/98/bc439871417621836a0eeea768d60944.jpg",request.getAddress(),request.getBirthDay(),request.getSex());
            Part file = request.getImage();
            if(file != null && file.getSize()!=0){
                //upload
                newEmployee.setImage("/uploads/"+file.getSubmittedFileName());
                file.write(uploadsPath + File.separator + file.getSubmittedFileName());
            }
            employees.add(newEmployee);
        }
    }

    @Override
    public void deleteById(Integer id) {
        employees.remove(findById(id));
    }
    private Integer getNewId(){
        return employees.stream().map(Employee::getId).max(Integer::compareTo).orElse(0) +1;
    }
}
