package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@Controller
@RestController
@RequestMapping("/courses")
public class CourseController {


    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
//    @ResponseBody
    public List<CourseDTO> getAllCourses(){
        return courseService.getCourses();
    }

    @GetMapping("{id}")
    public CourseDTO getCourseById(@PathVariable("id") Long courseId){
        return courseService.getCourseById(courseId);
    }

    @GetMapping("category/{name}")
    public List<CourseDTO>  getCoursesByCategory(@PathVariable("name") String name){
        return courseService.getCoursesByCategory(name);
    }

    @PostMapping
    public CourseDTO createCourse(@RequestBody CourseDTO course){
        return courseService.createCourse(course);
    }

    @PutMapping("{id}")
    public void updateCourse(@PathVariable("id") Long courseId,@RequestBody CourseDTO course){
        courseService.updateCourse(courseId,course);
    }

    @DeleteMapping("{id}")
    public void deleteCourseById(@PathVariable("id") Long courseId){
        courseService.deleteCourseById(courseId);
    }






}
