package com.example.hwswaggerint6.controller;

import com.example.hwswaggerint6.model.Student;
import com.example.hwswaggerint6.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student add(@RequestBody Student student) {
        return studentService.add(student);
    }

    @PutMapping
    public Student update(@RequestBody Student student) {
        return studentService.update(student);
    }

    @DeleteMapping
    public Student delete(@RequestParam Long id) {
        return studentService.delete(id);
    }

    @GetMapping
    public Student get(@RequestParam Long id) {
        return studentService.get(id);
    }

    @GetMapping("/all")
    public Map<Long, Student> getAll() {
        return studentService.getAll();
    }
}
