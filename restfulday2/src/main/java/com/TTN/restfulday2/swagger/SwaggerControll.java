package com.TTN.restfulday2.swagger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class SwaggerResource {


    @Autowired
    private SwaggerController swaggerController;

    public SwaggerResource(SwaggerController swaggerController) {

        this.swaggerController = swaggerController;
    }


    //getting all the Employee
    //mapping to specific url using GET
    @GetMapping("/swag")
    public List<Swagger> getAll()
    {

        return swaggerController.findAll();
    }



    //DELETE
    @DeleteMapping("/swag/{age}")
    public void delete(@PathVariable int age )
    {


        //deleting
        swaggerController.delete(age);

    }


    //Apply validation while
    // create a new employee using POST http Request.
    // create user
    @PostMapping("/swag")
    public ResponseEntity<Swagger> createUser(@RequestBody Swagger swagger)
    //requestBody for creating objects of json data
    {
        Swagger save= swaggerController.save(swagger);

        URI location= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{age}")
                .buildAndExpand(save.getAge())
                .toUri();
        // to return the uri location  of the created object

        return ResponseEntity.created(location).build(); // created and return the uri
    }





}

