package com.TTN.example;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> getAllCourses() {
        return Arrays.asList(new Course(1, "Learn JAVA", "Muskan"),
                new Course(1, "Learn JAVA", "Muskan")   ,
                new Course(3, "Learn JAVA9", "Muskan") ,
                new Course(1, "Learn JAVA", "Muskan") );

    }

}
