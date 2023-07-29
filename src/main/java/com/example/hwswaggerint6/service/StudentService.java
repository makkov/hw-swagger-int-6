package com.example.hwswaggerint6.service;

import com.example.hwswaggerint6.exception.StudentNotFoundException;
import com.example.hwswaggerint6.model.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {

    private static long ID_COUNTER = 1;

    private final Map<Long, Student> studentById = new HashMap<>();

    public Student add(Student student) {
        Student newStudent = new Student(ID_COUNTER, student.getName(), student.getAge());
        ID_COUNTER++;
        studentById.put(newStudent.getId(), newStudent);
        return newStudent;
    }

    public Student update(Student student) {
        Student studentForUpdate = studentById.get(student.getId());
        if (studentForUpdate == null) {
            throw new StudentNotFoundException();
        } else {
            studentForUpdate.setAge(student.getAge());
            studentForUpdate.setName(student.getName());
        }
        return studentForUpdate;
    }

    public Student delete(Long id) {
        if (!studentById.containsKey(id)) {
            throw new StudentNotFoundException();
        } else {
            return studentById.remove(id);
        }
    }

    public Student get(Long id) {
        if (!studentById.containsKey(id)) {
            throw new StudentNotFoundException();
        } else {
            return studentById.get(id);
        }
    }

    public Map<Long, Student> getAll() {
        return studentById;
    }
}
