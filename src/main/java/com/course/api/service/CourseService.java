package com.course.api.service;

import com.course.api.dto.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final List<Course> courses = new ArrayList<>();

    //Create a new course
    public void addCourse(Course course) {
        courses.add(course);
    }

    //Retrieve all courses
    public List<Course> getCourses(){
        return courses;
    }

    //Retrieve By Id
    public Optional<Course> getCourseById(int id){
        return courses.stream()
                .filter(course -> course.getId() == id)
                .findFirst();
    }
// Update a Course
    public boolean updateCourse(int id, Course course){
        return getCourseById(id).map(existingCourse -> {
            courses.remove(existingCourse);
            courses.add(course);
            return true;
        }).orElse(false);
    }

    //Delete a Course By Id
    public boolean deleteCourse(int id){
        return courses.removeIf(course -> course.getId() == id);
    }
}

