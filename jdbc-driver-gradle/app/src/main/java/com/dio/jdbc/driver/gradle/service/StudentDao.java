package com.dio.jdbc.driver.gradle.service;

import com.dio.jdbc.driver.gradle.model.StudentPojo;

import java.util.List;

public interface StudentDao {

    void createStudent(StudentPojo student);

    List<StudentPojo> getAllStudents();

    StudentPojo getStudentById(int studentId);

    void updateStudent(StudentPojo student);

    void deleteStudent(int studentId);
}