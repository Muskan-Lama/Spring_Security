package com.TTN.spring.quetion2to9;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


//managed by spring and it is autowired in Employee resource
@Component
public class EmployeeDaoService {


    //list
    private static List<Employee> employees = new ArrayList<>();


    //setting up values of Employee bean
    static
    {
        employees.add(new Employee(12,"muskan",23));
        employees.add(new Employee(13,"sofi",22));


    }


    //returns all Employee data using List in json format
    public List<Employee> findAll()
    {
        return employees;
    }



    //method which will match and return the employee details according to id
    public Employee findOne(int id)
    {

       //functional programming
        Predicate<? super Employee> predicate =
                employee -> employee.getId()==(id);


        //concerting List to stream
        //orElse if id is not found to handle exception
        //but no response will come
       return employees.stream().filter(predicate).findFirst().orElse(null);
    }


    //save the Employee which is newely created
    // and return it and display in json
    public Employee save(Employee employee)
    {
       employees.add(employee);
       return employee;
    }


    //method to delete
    public void delete(int id)
    {

        //functional programming
        Predicate<? super Employee> predicate =
                employee -> employee.getId()==(id);

        //deleting by id
         employees.remove(predicate);


    }
    //put method
    //PUT is used to send data to a server to create/update a resource.
    public void updateById(Integer id, Employee employee)
    {
        for (int i=0; i<employees.size(); i++)
        {
            Employee curr = employees.get(i);
            if (curr.getId() == id) {
                employees.set(i, employee);

            }
        }
    }

}
