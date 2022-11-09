package com.TTN.spring.quetion5;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeResource {


    @Autowired
    private EmployeeDaoService employeeDaoService;

    public EmployeeResource(EmployeeDaoService employeeDaoService)
    {

        this.employeeDaoService=employeeDaoService;
    }


    //getting all the Employee
    //mapping to specific url using GET
    @GetMapping("/users")
    public List<Employee> getAll()
    {

        return employeeDaoService.findAll();
    }



    //getting Pathvariable
    //Implement GET
    // http request using path variable top get one employee
    @GetMapping("/users/{id}")
    public Employee findOne(@PathVariable int id)
    {


        Employee employee=employeeDaoService.findOne(id);
           //handling exception by using custom exception class and displaying message
        if(employee==null)
            throw new IdNotFoundException("id : "+ id);
        //it will return the employee details which matches the specific id
        return employee;
    }


    //DELETE
    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable int id)
    {


        //deleting
       employeeDaoService.delete(id);

    }



    //post
    //Implement POST http request for Employee to create a new employee.
    @PostMapping("/users")
    //send web request with body along with it
    //in body it will have all request and that will be mapped to Employee bean
    public void createEmployee(@RequestBody Employee employee)
    {
          employeeDaoService.save(employee);
    }




    //put mapping
    @PutMapping(path = "/users/{id}")
    public void updateEmployee(@RequestBody Employee employee, @PathVariable Integer id) {
        employeeDaoService.updateById(id, employee);
    }



}
