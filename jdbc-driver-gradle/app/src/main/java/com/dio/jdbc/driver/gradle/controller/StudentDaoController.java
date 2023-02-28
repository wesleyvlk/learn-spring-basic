package com.dio.jdbc.driver.gradle.controller;

import com.dio.jdbc.driver.gradle.model.StudentPojo;
import com.dio.jdbc.driver.gradle.service.implementation.StudentDaoImpl;

import java.util.List;

public class StudentDaoController {
    static StudentDaoImpl studentDao = new StudentDaoImpl();

    public static void main(String[] args) {
        createStudent("name", 1, "UF");

        getAllStudents();

        getStudentById(1);

        updateStudent(1, "name", 1, "UF");

        deleteStudent(1);
    }

    public static void createStudent(String name, Integer age, String stateCode) {
        StudentPojo studentCreate = new StudentPojo(name, age, stateCode);
        studentDao.createStudent(studentCreate);
    }

    static void getAllStudents() {
        List<StudentPojo> students = studentDao.getAllStudents();
        students.stream().forEach(System.out::println);
    }

    static void getStudentById(Integer studentId) {
        StudentPojo studentById = studentDao.getStudentById(studentId);
        System.out.println(studentById);
    }

    static void updateStudent(Integer studentId, String name, Integer age, String stateCode) {
        StudentPojo studentUpdate = studentDao.getStudentById(studentId);
        studentUpdate.setName(name);
        studentUpdate.setAge(age);
        studentUpdate.setStateCode(stateCode);
        studentDao.updateStudent(studentUpdate);
    }

    static void deleteStudent(Integer studentId) {
        studentDao.deleteStudent(studentId);
    }
}
